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

import br.com.serratec.lojinha.model.formapagamento.FormaPagamento;
import br.com.serratec.lojinha.service.FormaPagamentoService;

@RestController
@RequestMapping("/api/forma-pagamentos")
public class FormaPagamentoController {
    
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> obterTodos(){
        return formaPagamentoService.obterTodos();
    }

    @GetMapping("/{id}")
    public FormaPagamento obter(@PathVariable long id){
        return this.formaPagamentoService.obter(id);
    }

    @PostMapping
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento){
        return formaPagamentoService.adicionar(formaPagamento);
    }

    @PutMapping("/{id}")
    public FormaPagamento atualizar(@PathVariable long id, @RequestBody FormaPagamento formaPagamento){
        return formaPagamentoService.atualizar(id, formaPagamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        formaPagamentoService.deletar(id);
    }
}
