package br.com.serratec.lojinha.service;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.lojinha.model.cliente.Cliente;
import br.com.serratec.lojinha.model.exceptions.ResourceNotFoundException;
import br.com.serratec.lojinha.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obterTodos(){
        
        return clienteRepository.obterTodos();
    }

    public Cliente obter(long id){
        // Aqui eu colocaria a minha regra, validação e etc...
        Cliente cliente = clienteRepository.obter(id);

        if(cliente == null){
            throw new ResourceNotFoundException("Não foi possivel encontrar o cliente com Id: " + id);
        }

        return cliente;
    }
    
    public Cliente adicionar(Cliente cliente){
        // Aqui validar se tudo do cliente está ok antes de mandar salvar no repository...
        return clienteRepository.adicionar(cliente);
    }

    public Cliente atualizar(long id, Cliente cliente){
        // Aqui validar se tudo do cliente está ok antes de mandar salvar no repository...
        Cliente clienteEncontrado = clienteRepository.obter(id);

        if(clienteEncontrado == null){
            throw new ResourceNotFoundException("Não foi possivel atualizar o cliente com Id: " + id);
        }

        cliente.setId(id);

        return clienteRepository.atualizar(cliente);     
    }

    public void deletar(long id){
       clienteRepository.deletar(id);
    }
}
