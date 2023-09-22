package exercicio_Heranca;

public class Poupanca extends Conta{
	private double rendimento;

	public Poupanca(int numero, String titular, double saldo, double rendimento) {
		super(numero, titular, saldo);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
}
