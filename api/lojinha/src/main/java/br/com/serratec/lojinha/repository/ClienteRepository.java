package br.com.serratec.lojinha.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.serratec.lojinha.model.cliente.Cliente;

@Repository
public class ClienteRepository {
    
    private List<Cliente> clientes = new ArrayList<>();
    private long ultimoId = 0;

    public List<Cliente> obterTodos(){
        return clientes;
    }

    public Cliente obter(long id){

        Cliente clienteEncontrado = null;

        for (Cliente cliente : clientes) {

            if(cliente.getId() == id){
                clienteEncontrado = cliente;
            }
        }

        return clienteEncontrado;
    }
    
    public Cliente adicionar(Cliente cliente){

        ultimoId++;
        cliente.setId(ultimoId);

        clientes.add(cliente);

        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        
        // Remover o antigo.
        clientes.removeIf(p -> p.getId() == cliente.getId());

        // Adicionar o novo.
        clientes.add(cliente);

        return cliente;
    }

    public void deletar(long id){
        clientes.removeIf(p -> p.getId() == id);
    }

}
