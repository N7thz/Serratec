package br.com.serratec.lojinha.model.pagamento;

public class Pagamento {

    //#region Getter's and Setter's
    private long id;
    private String descricao;

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
    //#endregion
    
}
