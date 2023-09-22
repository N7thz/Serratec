package classes;

public class Diretor extends Funcionario {
	private double dividendos;
	
	public double getDividendos() {
		return dividendos;
	}
	
	public Diretor(String nome, String cpf, double salario, double bonus) {
		super(nome, cpf, salario, bonus);
	}

	public void setDividendos(double dividendos) {
		this.dividendos = dividendos;
	}
	
	public double getBonificacao() {
		return getSalario() * 0.20;
	}
	
	public double calcularValorFinal() {
		return getSalario() + getBonificacao() + getBonusEspecial();
	}

}
