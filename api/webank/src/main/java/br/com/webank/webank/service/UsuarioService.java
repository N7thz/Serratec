package br.com.webank.webank.service;

import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.webank.webank.dto.endereco.EnderecoResponseDTO;
import br.com.webank.webank.dto.usuario.UsuarioLoginResponseDTO;
import br.com.webank.webank.dto.usuario.UsuarioRequestDTO;
import br.com.webank.webank.dto.usuario.UsuarioResponseDTO;
import br.com.webank.webank.model.Endereco;
import br.com.webank.webank.model.Usuario;
import br.com.webank.webank.repository.UsuarioRepository;
import br.com.webank.webank.security.JWTAuthenticationFilter;
import br.com.webank.webank.security.JWTService;

@Service
public class UsuarioService  implements CRUDService<UsuarioRequestDTO, UsuarioResponseDTO, Long>{

    private static final String BEARER = "Bearer ";
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public List<UsuarioResponseDTO> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
            .map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obterPorId(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);

        if(optUsuario.isEmpty()){
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }

        return mapper.map(optUsuario.get(), UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO adicionar(UsuarioRequestDTO requestDto) {

        Usuario usuario = mapper.map(requestDto, Usuario.class);
        
        // Aqui to criptografando a senha antes de salvar no banco de dados.
        String senha =  passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senha);
        usuario.setId(0);

        usuario = usuarioRepository.save(usuario);

        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    public UsuarioResponseDTO obterPorEmail(String email){
        Optional<Usuario> optUsuario =  usuarioRepository.findByEmail(email);

        return mapper.map(optUsuario.get(),UsuarioResponseDTO.class);
    }

    public UsuarioLoginResponseDTO logar(String email, String senha){
        // Aqui que a autenticação acontece dentro do spring automagicamente.

        Optional<Usuario> optUsuario =usuarioRepository.findByEmail(email);

        if(optUsuario.isEmpty()){
            throw new BadCredentialsException("Usuário ou senha invalidos");
        }

        Authentication autenticacao = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(email, senha,Collections.emptyList()));
            
        // Aqui eu passo a nova autenticação para o springSecurity cuidar pra mim.
        SecurityContextHolder.getContext().setAuthentication(autenticacao);

        // Crio o token JWT
        String token =  BEARER + jwtService.gerarToken(autenticacao);
    
        // Pego o usuario dono do token
        UsuarioResponseDTO usuarioResponse = obterPorEmail(email);

        // Crio e devolvo o DTO esperado.
        return new UsuarioLoginResponseDTO(token, usuarioResponse);
    }
    
}
