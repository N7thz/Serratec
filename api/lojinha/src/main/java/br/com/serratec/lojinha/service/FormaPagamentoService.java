package br.com.serratec.lojinha.service;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.lojinha.model.exceptions.ResourceNotFoundException;
import br.com.serratec.lojinha.model.formapagamento.FormaPagamento;
import br.com.serratec.lojinha.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
    
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamento> obterTodos(){
        
        return formaPagamentoRepository.obterTodos();
    }

    public FormaPagamento obter(long id){
        // Aqui eu colocaria a minha regra, validação e etc...
        FormaPagamento formaPagamento = formaPagamentoRepository.obter(id);

        if(formaPagamento == null){
            throw new ResourceNotFoundException("Não foi possivel encontrar o formaPagamento com Id: " + id);
        }

        return formaPagamento;
    }
    
    public FormaPagamento adicionar(FormaPagamento formaPagamento){
        // Aqui validar se tudo do formaPagamento está ok antes de mandar salvar no repository...
        return formaPagamentoRepository.adicionar(formaPagamento);
    }

    public FormaPagamento atualizar(long id, FormaPagamento formaPagamento){
        // Aqui validar se tudo do formaPagamento está ok antes de mandar salvar no repository...
        FormaPagamento formaPagamentoEncontrado = formaPagamentoRepository.obter(id);

        if(formaPagamentoEncontrado == null){
            throw new ResourceNotFoundException("Não foi possivel atualizar o formaPagamento com Id: " + id);
        }

        formaPagamento.setId(id);

        return formaPagamentoRepository.atualizar(formaPagamento);     
    }

    public void deletar(long id){
       formaPagamentoRepository.deletar(id);
    }
}
