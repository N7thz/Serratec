package br.com.webank.webank.dto.usuario;

import br.com.webank.webank.model.ETipoPerfil;

public class UsuarioRequestDTO {
    
    private String nome;

    private String email;

    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ETipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(ETipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    //
}
