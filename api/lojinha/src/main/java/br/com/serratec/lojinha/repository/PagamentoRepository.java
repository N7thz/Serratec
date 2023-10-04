package br.com.serratec.lojinha.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.serratec.lojinha.model.pagamento.Pagamento;

@Repository
public class PagamentoRepository {
    
    private List<Pagamento> pagamentos = new ArrayList<>();
    private long ultimoId = 0;

    public List<Pagamento> obterTodos(){
        return pagamentos;
    }

    public Pagamento obter(long id){

        Pagamento pagamentoEncontrado = null;

        for (Pagamento Pagamento : pagamentos) {

            if(Pagamento.getId() == id){
                pagamentoEncontrado = Pagamento;
            }
        }

        return pagamentoEncontrado;
    }
    
    public Pagamento adicionar(Pagamento pagamento){

        ultimoId++;
        pagamento.setId(ultimoId);

        pagamentos.add(pagamento);

        return pagamento;
    }

    public Pagamento atualizar(Pagamento pagamento){
        
        // Remover o antigo.
        pagamentos.removeIf(p -> p.getId() == pagamento.getId());

        // Adicionar o novo.
        pagamentos.add(pagamento);

        return pagamento;
    }

    public void deletar(long id){
        pagamentos.removeIf(p -> p.getId() == id);
    }

}
