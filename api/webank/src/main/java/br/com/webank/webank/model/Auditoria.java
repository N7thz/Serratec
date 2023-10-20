package br.com.webank.webank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Auditoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private ETipoEntidade entidade;

    @Column(nullable = false)
    private String acao;

    private String valorOriginal;

    private String valorAtualizado;

    @ManyToOne()
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Date dataAcao;

    public Auditoria(ETipoEntidade entidade, String acao, String valorOriginal, String valorAtualizado, Usuario usuario) {
        this.entidade = entidade;
        this.acao = acao;
        this.valorOriginal = valorOriginal;
        this.valorAtualizado = valorAtualizado;
        this.usuario = usuario;
        this.dataAcao = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ETipoEntidade getEntidade() {
        return entidade;
    }

    public void setEntidade(ETipoEntidade entidade) {
        this.entidade = entidade;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(String valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getValorAtualizado() {
        return valorAtualizado;
    }

    public void setValorAtualizado(String valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

    public Date getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(Date dataAcao) {
        this.dataAcao = dataAcao;
    }
}
