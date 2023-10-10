package br.com.webank.webank.model;

import java.util.Date;

public class ContaCorrente {

    private long id;
    private String agencia;
    private String numero;
    private double saldo;
    private Date dataCadastro;
    
    public ContaCorrente(long id, String agencia, String numero, double saldo) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataCadastro = new Date();
    }

    public ContaCorrente() {
        this.dataCadastro = new Date();
    }
    
    //#region Getter's and Setter's
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAgencia() {
            return agencia;
        }

        public void setAgencia(String agencia) {
            this.agencia = agencia;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public Date getDataCadastro() {
            return dataCadastro;
        }

        public void setDataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
        }
    //#endregion
}
