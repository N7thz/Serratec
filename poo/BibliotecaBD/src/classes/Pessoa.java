package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Pessoa {
	private String nome;
	private LocalDate dtNasc;
	private String rg;
	private String cpf;
	private char sexo;
	private String endereco;
	
	public void dadosPessoa() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 			
		
		System.out.println("");
		System.out.println("Dados-------------------------------");
		System.out.printf("Nome: %s%n", this.nome);
		
		if (dtNasc != null)
			System.out.printf("Data nasc.: %d%n", dtNasc.toString().formatted(dtf));
		else
			System.out.printf("Data nasc.: %n");
		
		System.out.printf("RG: %s%n", this.rg);
		System.out.printf("CPF: %s%n", this.cpf);
		System.out.printf("Sexo: %s%n", this.sexo);
		System.out.println("------------------------------------");
	}
	
	public void alterar() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Alteracao de dados");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Nome: ");
		String s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank() && s != null)
			this.nome = s;
		
		System.out.println("CPF: ");
		s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank() && s != null)
			this.cpf = s;
		
		System.out.println("RG: ");
		s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank() && s != null)
			this.rg = s;		
		
		System.out.println("Endereco: ");
		s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank() && s != null)
			this.endereco = s;
		
		System.out.println("Data nascimento (dd/MM/yyyy): ");
		s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank() && s != null) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy"); 
			
			this.dtNasc = LocalDate.parse(s, formato);
		}
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	
}
