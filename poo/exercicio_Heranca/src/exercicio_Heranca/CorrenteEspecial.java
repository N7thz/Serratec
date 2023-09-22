package exercicio_Heranca;

public class CorrenteEspecial extends Corrente {
	private long nCartaoCredito;
	
	public CorrenteEspecial(int numero, String titular, double saldo, double tarifa, double limite,
			long nCartaoCredito) {
		super(numero, titular, saldo, tarifa, limite);
		this.nCartaoCredito = nCartaoCredito;
	}

	public long getnCartaoCredito() {
		return nCartaoCredito;
	}

	public void setnCartaoCredito(long nCartaoCredito) {
		this.nCartaoCredito = nCartaoCredito;
	}
}


