package br.com.serratec.lojinha.service;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.lojinha.model.exceptions.ResourceNotFoundException;
import br.com.serratec.lojinha.model.produto.Produto;
import br.com.serratec.lojinha.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        
        return produtoRepository.obterTodos();
    }

    public Produto obter(long id){
        // Aqui eu colocaria a minha regra, validação e etc...
        Produto produto = produtoRepository.obter(id);

        if(produto == null){
            throw new ResourceNotFoundException("Não foi possivel encontrar o produto com Id: " + id);
        }

        return produto;
    }
    
    public Produto adicionar(Produto produto){
        // Aqui validar se tudo do produto está ok antes de mandar salvar no repository...
        produto.validarParaCadastro();
        return produtoRepository.adicionar(produto);
    }

    public Produto atualizar(long id, Produto produto){
        // Aqui validar se tudo do produto está ok antes de mandar salvar no repository...
        Produto produtoEncontrado = produtoRepository.obter(id);

        if(produtoEncontrado == null){
            throw new ResourceNotFoundException("Não foi possivel atualizar o produto com Id: " + id);
        }

        produto.setId(id);

        return produtoRepository.atualizar(produto);     
    }

    public void deletar(long id){
       produtoRepository.deletar(id);
    }
}
