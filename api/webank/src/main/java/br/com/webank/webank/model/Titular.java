package br.com.webank.webank.model;

import java.util.Date;
import java.util.List;

public class Titular {
    
    private long id;
    private String mome;
    private String cpfOuCnpj;
    private String email;
    private String telefone;
    private String senha;
    private Date dataNascimento;
    private Endereco enderecoPrincipal;
    private Endereco enderecoCobranca;
    private List<ContaCorrente> contas;
    
}
