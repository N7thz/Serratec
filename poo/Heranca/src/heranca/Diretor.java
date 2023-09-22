package heranca;

public class Diretor extends funcionario {
	private double dividendos;
	
	public Diretor(String nome, String cpf, double salario, double bonus, double dividendos) {
		super(nome, cpf, salario, bonus);
		this.dividendos = dividendos;
	}

	public double getBonificacao() { 
		return getSalario() * 0.2;
	}
	
	public double calcularValorFinal() { 
		return getSalario() + getBonificacao() + getBonusEspecial();
	}
	

	public double getDividendos() {
		return dividendos;
	}

	public void setDividendos(double dividendos) {
		this.dividendos = dividendos;
	}
}
