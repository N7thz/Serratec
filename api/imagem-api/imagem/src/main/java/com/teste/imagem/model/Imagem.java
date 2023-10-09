package com.teste.imagem.model;

@Entity
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String contentType;
    
    @Lob
    private byte[] dados;

}
