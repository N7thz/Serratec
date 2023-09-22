package exercicio_Heranca;

public class PoupancaEspecial extends Poupanca {
	private long nCartaoDebito;
	
	public PoupancaEspecial(int numero, String titular, double saldo, double rendimento, long nCartaoDebito) {
		super(numero, titular, saldo, rendimento);
		this.nCartaoDebito = nCartaoDebito;
	}

	public long getnCartaoDebito() {
		return nCartaoDebito;
	}

	public void setnCartaoDebito(long nCartaoDebito) {
		this.nCartaoDebito = nCartaoDebito;
	}
	
}
