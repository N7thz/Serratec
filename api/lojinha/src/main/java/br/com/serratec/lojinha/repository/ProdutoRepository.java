package br.com.serratec.lojinha.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.serratec.lojinha.model.produto.Produto;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<>();
    private long ultimoId = 0;

    public List<Produto> obterTodos(){
        return produtos;
    }

    public Produto obter(long id){

        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {

            if(produto.getId() == id){
                produtoEncontrado = produto;
            }
        }

        return produtoEncontrado;
    }
    
    public Produto adicionar(Produto produto){

        ultimoId++;
        produto.setId(ultimoId);

        produtos.add(produto);

        return produto;
    }

    public Produto atualizar(Produto produto){
        
        // Remover o antigo.
        produtos.removeIf(p -> p.getId() == produto.getId());

        // Adicionar o novo.
        produtos.add(produto);

        return produto;
    }

    public void deletar(long id){
        produtos.removeIf(p -> p.getId() == id);
    }

}
