package br.com.serratec.lojinha.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.serratec.lojinha.model.formapagamento.FormaPagamento;

@Repository
public class FormaPagamentoRepository {
    
    private List<FormaPagamento> formaPagamentos = new ArrayList<>();
    private long ultimoId = 0;

    public List<FormaPagamento> obterTodos(){
        return formaPagamentos;
    }

    public FormaPagamento obter(long id){

        FormaPagamento formaPagamentoEncontrado = null;

        for (FormaPagamento formaPagamento : formaPagamentos) {

            if(formaPagamento.getId() == id){
                formaPagamentoEncontrado = formaPagamento;
            }
        }

        return formaPagamentoEncontrado;
    }
    
    public FormaPagamento adicionar(FormaPagamento formaPagamento){

        ultimoId++;
        formaPagamento.setId(ultimoId);

        formaPagamentos.add(formaPagamento);

        return formaPagamento;
    }

    public FormaPagamento atualizar(FormaPagamento formaPagamento){
        
        // Remover o antigo.
        formaPagamentos.removeIf(p -> p.getId() == formaPagamento.getId());

        // Adicionar o novo.
        formaPagamentos.add(formaPagamento);

        return formaPagamento;
    }

    public void deletar(long id){
        formaPagamentos.removeIf(p -> p.getId() == id);
    }

}
