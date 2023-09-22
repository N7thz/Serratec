package classes;

public class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	private double bonus = 0;
	
	public Funcionario(String nome, String cpf, double salario, double bonus) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.bonus = bonus;
	}
	
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getBonificacao() {
		return getSalario() * 0.10;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double calcularValorFinal() {
		return getSalario() + getBonificacao();
	}
	
	public double getBonusEspecial() {
		return bonus;
	}
}
