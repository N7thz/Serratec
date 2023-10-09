package com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities;

// import java.math.String;

public class Doguinhos {

    private long id;
    
    private String nome;

    private int idade;
    
    private String tamanho;

    private Raca raca;

    private String imagem;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Doguinhos(String nome, int idade, String tamanho, Raca raca, String imagem) {
        this.nome = nome;
        this.idade = idade;
        this.tamanho = tamanho;
        this.raca = raca;
        this.imagem = imagem;
    }
}
