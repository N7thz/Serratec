package br.com.serratec.lojinha.controller;

import java.lang.reflect.Array;
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

import br.com.serratec.lojinha.model.produto.Produto;
import br.com.serratec.lojinha.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
// informações do controller
@RequestMapping("/api/produtos")
@Tag(name = "/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    // operation da um resumo do que o metodo faz
    @Operation(summary = "Obtem todos os produtos", method = "GET")
    // respostas provaveis para o metodo
    //#region apiResponses
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Os produtos foram retornados com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar os produtos."),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o metodo.")
    })
    //#endregion

    public ResponseEntity<List<Produto>> obterTodos(){

        List<Produto> produtos = produtoService.obterTodos();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtem o produto pelo id", method = "GET")
    //#region apiResponses
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "O produtos foi retornado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o produto"),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o metodo.")
    })
    //#endregion

    public ResponseEntity<Produto> obter(@PathVariable long id){

        return ResponseEntity.ok(produtoService.obter(id));
    }

    @Operation(summary = "adiona um produto a lista de produtos", method = "POST")
    //#region apiResponses
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "O produtos foi adionado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel adionar o produto"),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o metodo.")
    })
    //#endregion

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto){

        Produto produtoAdicionado = produtoService.adicionar(produto);
        return new ResponseEntity<>(produtoAdicionado, HttpStatus.CREATED);
    }

    @Operation(summary = "atualiza um produto a lista de produtos", method = "PUT")
    //#region apiResponses
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "O produtos foi atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel atualizar o produto"),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o metodo.")
    })
    //#endregion

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable long id, @RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.atualizar(id, produto));
    }

    
    @Operation(summary = "exclui um produto a lista de produtos", method = "DELETE")
    //#region apiResponses
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "O produtos foi excluido com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel excluido o produto"),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o metodo.")
    })
    //#endregion

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}               
