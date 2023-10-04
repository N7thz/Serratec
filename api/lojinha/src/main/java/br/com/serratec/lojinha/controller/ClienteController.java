package br.com.serratec.lojinha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.lojinha.model.cliente.Cliente;
import br.com.serratec.lojinha.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos(){
        return clienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Cliente obter(@PathVariable long id){
        return this.clienteService.obter(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable long id, @RequestBody Cliente cliente){
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        clienteService.deletar(id);
    }
}
