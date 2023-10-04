package br.com.serratec.lojinha.model.produto;

import java.util.Date;

import br.com.serratec.lojinha.model.exceptions.ResourceBadRequestException;

public class Produto {
    
    //#region propriedades
    private long id;
    private String descricao;
    private int quantidade;
    private double valorCusto;
    private double valorVenda;
    private Date dataCadastro;

    //#endregion

    //#region Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }  
    
    //#endregion

    public void validarParaCadastro(){
        if(descricao.equals("") || quantidade < 0){
           throw new ResourceBadRequestException("Os campos descrição e quantidade são obrigatorios.") ;
        }     
    }
}
