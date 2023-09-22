package exercicio_Heranca;

public class Corrente extends Conta {
	private double tarifa;
	private double limite;

	public Corrente(int numero, String titular, double saldo, double tarifa, double limite) {
		super(numero, titular, saldo);
		this.tarifa = tarifa;
		this.limite = limite;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
}
