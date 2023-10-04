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

import br.com.serratec.lojinha.model.pagamento.Pagamento;
import br.com.serratec.lojinha.service.PagamentoService;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> obterTodos(){
        return pagamentoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Pagamento obter(@PathVariable long id){
        return this.pagamentoService.obter(id);
    }

    @PostMapping
    public Pagamento adicionar(@RequestBody Pagamento pagamento){
        return pagamentoService.adicionar(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable long id, @RequestBody Pagamento pagamento){
        return pagamentoService.atualizar(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        pagamentoService.deletar(id);
    }
}
