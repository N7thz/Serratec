package classes;

import java.util.Scanner;

public class Funcionarios extends Pessoa {
	private String cargo;
	private double salario;
	private String ctps;
	private int idFuncionario; 
	
	public void dadosPessoa() {
		super.dadosPessoa();
		System.out.printf("Cargo: %s%n", this.cargo);
		System.out.printf("Salario: %d%n", this.salario);
		System.out.printf("CTPS: %s%n", this.ctps);		
	}
	
	public void alterar() {
		super.alterar();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Cargo: ");
		String s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank())
			this.cargo = s;
		
		System.out.println("CTPS: ");
		s = in.nextLine();
		
		if (!s.isEmpty() && !s.isBlank())
			this.ctps = s;
		
		System.out.println("Salario: ");
		Double d = in.nextDouble();
		
		if (!s.isEmpty() && !s.isBlank())
			this.salario = d;
		
	}
	
 	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
}
