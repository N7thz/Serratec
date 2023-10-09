package br.com.serratec.lojinha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FormaPagamento>> obterTodos() {

        List<FormaPagamento> pagamentos = formaPagamentoService.obterTodos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> obter(@PathVariable long id) {

        return ResponseEntity
            .status(200)
            .body(formaPagamentoService.obter(id));
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> adicionar(@RequestBody FormaPagamento formaPagamento) {

        return new ResponseEntity<>(formaPagamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable long id, @RequestBody FormaPagamento formaPagamento) {

        return ResponseEntity.ok(formaPagamentoService.atualizar(id, formaPagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
