package br.com.webank.webank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.webank.webank.dto.endereco.EnderecoRequestDTO;
import br.com.webank.webank.dto.endereco.EnderecoResponseDTO;
import br.com.webank.webank.model.Auditoria;
import br.com.webank.webank.model.ETipoEntidade;
import br.com.webank.webank.model.Endereco;
import br.com.webank.webank.model.Titular;
import br.com.webank.webank.model.Usuario;
import br.com.webank.webank.paser.EnderecoParser;
import br.com.webank.webank.repository.AuditoriaRepository;
import br.com.webank.webank.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AuditoriaService auditoriaService;

    public List<EnderecoResponseDTO> obterTodos(){
        // Aqui preciso converter a minha lista de endereco em uma lista de enderecoResponseDTO
        List<Endereco> enderecosModel = enderecoRepository.findAll();
        
        List<EnderecoResponseDTO> enderecosResponse = new ArrayList<>();

        for (Endereco endereco : enderecosModel) {
            // enderecosResponse.add(new EnderecoResponseDTO(endereco));
            enderecosResponse.add(mapper.map(endereco, EnderecoResponseDTO.class));
        }

        return  enderecosResponse;
    }

    public EnderecoResponseDTO obterPorId(long id){
        Optional<Endereco> optEndereco = enderecoRepository.findById(id);

        if(optEndereco.isEmpty()){
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }

        // return new EnderecoResponseDTO(optEndereco.get());
        return mapper.map(optEndereco.get(), EnderecoResponseDTO.class);
    }

    // O save serve tanto para adicionar quanto para atualizar.
    // se tiver id, ele atualiza, s enão tiver id ele adiciona.
    public EnderecoResponseDTO adicionar(EnderecoRequestDTO enderecoRequest){

        // Pegando o usuario authenticado para auditoria
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        Endereco enderecoModel = mapper.map(enderecoRequest, Endereco.class);
        // enderecoModel.setTitular(new Titular(enderecoRequest.getIdTitular()));

        enderecoModel = enderecoRepository.save(enderecoModel);

        // Depois de adicionar, gravar a auditoria.
        try {
            
            Auditoria auditoria = new Auditoria(
            ETipoEntidade.ENDERECO,
            "CADASTRO", 
            "", 
            new ObjectMapper().writeValueAsString(enderecoModel),
            usuario);

            auditoriaService.registrarAuditoria(auditoria);

        } catch (Exception e) {
            
        }

        // return new EnderecoResponseDTO(enderecoModel);
        return mapper.map(enderecoModel, EnderecoResponseDTO.class);
    }

    public EnderecoResponseDTO atualizar(long id, EnderecoRequestDTO endereco){

        // Se não lançar exception é porque o cara existe no banco.
        var  enderecoBanco = obterPorId(id);        

        // Endereco enderecoModel = EnderecoParser.converterEnderecoRequestEmEnderecoModel(endereco);
        Endereco enderecoModel = mapper.map(endereco, Endereco.class);
        enderecoModel.setId(id);

        Titular titular = mapper.map(endereco.getTitular(), Titular.class);
        enderecoModel.setTitular(titular);

        enderecoModel = enderecoRepository.save(enderecoModel);

        // Depois de atualizar, gravar a auditoria.
        try {
            
            // Pegando o usuario authenticado para auditoria
            Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
            Auditoria auditoria = new Auditoria(
            ETipoEntidade.ENDERECO,
            "ATUALIZACAO", 
            new ObjectMapper().writeValueAsString(enderecoBanco), 
            new ObjectMapper().writeValueAsString(enderecoModel),
            usuario);

            auditoriaService.registrarAuditoria(auditoria);

        } catch (Exception e) {
            
        }

        return EnderecoParser.converterEnderecoModelEmEnderecoResponseDTO(enderecoModel);
    }

    public void deletar(Long id){
        obterPorId(id);

        enderecoRepository.deleteById(id);
    }

}
