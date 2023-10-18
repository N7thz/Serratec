package br.com.webank.webank.dto.usuario;

import br.com.webank.webank.model.ETipoPerfil;

public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private ETipoPerfil tipoPerfil;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ETipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(ETipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
