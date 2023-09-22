package classes;

import java.time.LocalDateTime;

public class Empresa extends Cadastro{
	private String razao_Social;

	public Empresa() {
		super();
	}

	public Empresa(String nome, String cpf_cnpj, String endereco, String telefone, String data_hora,String razao_Social) {
		super(nome, cpf_cnpj, endereco, telefone, data_hora);
		this.razao_Social = razao_Social;
	}



}
