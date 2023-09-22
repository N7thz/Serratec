package heranca;

public class Gerente extends funcionario {
	private int senha;
	private int numeroDeFuncionarios;
	private double bonus = 1000;
	
	public Gerente(String nome, String cpf, double salario, double bonus, int senha, int numeroDeFuncionarios,double bonus2) {
		super(nome, cpf, salario, bonus);
		this.senha = senha;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
		bonus = bonus2;
	}

	public double getBonificacao() { 
		return getSalario() * 0.15;
	}
	
	public double calcularValorFinal() { 
		return getSalario() + getBonificacao() + getBonusEspecial();
	}

	public boolean autenticar(int senha) {
		if (this.senha == senha) {
			System.out.println("Acesso permitido");
			return true;
		} else {
			System.out.println("Acesso negado");
			return false;
		}
	}
	
	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
}


