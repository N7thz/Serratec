package exercicio_Heranca;

public class Conta {
	private int numero;
	private String titular;
	private double saldo = 0;
	
	public Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		depositar(saldo);
	}
	
	boolean sacar(double valor) {
		if (getSaldo() < valor) {
			return false;
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return true;
		}
	}
	
	public int getNumero() {
		return numero;
	}

	/*
	public void setNumero(int numero) {
		this.numero = numero;
	}
	*/

	public String getTitular() {
		return titular;
	}

	/*
	public void setTitular(String titular) {
		this.titular = titular;
	}
	*/

	public double getSaldo() {
		return saldo;
	}

	/*
	public void setSaldo(double saldo) {		
		depositar(saldo);
	}
	*/
	
	boolean transferir(Conta destino, double valor) {
		if (sacar(valor)) {
			destino.depositar(valor);
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}
	
	boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		} else {
			return false;
		}
	}
	
	void imprimirSaldo() {
		System.out.println("Saldo da conta: " + this.saldo);
	}
	
	void imprimirDados() {
		System.out.println("Numero da conta: " + this.numero);
		System.out.println("Titular: " + this.titular);
	}
}
