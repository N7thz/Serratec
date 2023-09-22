package classes;

public class Gerente extends Funcionario {
	private int senha = 123;
	private int numeroDeFuncionarios;
	
	public Gerente(String nome, String cpf, double salario, double bonus) {
		super(nome, cpf, salario, bonus);
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

	public double getBonificacao() {
		return getSalario() * 0.15;
	}
	
	public double calcularValorFinal() {
		return getSalario() + getBonificacao() + getBonusEspecial();
	}
	
	
}
