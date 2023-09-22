package Main;

import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private String cpf;
	private LocalDate data_Nasc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getData_Nasc() {
		return data_Nasc;
	}
	public void setData_Nasc(LocalDate data_Nasc) {
		this.data_Nasc = data_Nasc;
	}
}
