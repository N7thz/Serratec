package principal;

import exercicio_Heranca.*;

public class Principal {
	public static void main(String[] args) {
		
		Corrente c = new Corrente(1234, "Rogerio Alfredo", 1000, 0.10, 500);
		Poupanca p = new Poupanca(1234, "Rogerio Alfredo", 1000,0.05);
		
		imprimirMenu("CORRENTE");
		imprimirDados(c);
		System.out.println("Limite de transações: " + c.getLimite());
		System.out.println("Tarifa: " + (c.getTarifa() * 100) + "%");
		
		imprimirMenu("POUPANÇA");
		imprimirDados(p);
		System.out.println("Rendimento: " + (p.getRendimento()* 100) + "%");
		
	}
	
	public static void imprimirDados(Conta cont) {
		System.out.println("Numero da conta: " + cont.getNumero());
		System.out.println("Nome do cliente: " + cont.getTitular());
		System.out.println("Saldo da conta: " + cont.getSaldo());

	}	
	
	public static void imprimirMenu(String obj) {
		System.out.println("==============================================");
		System.out.println("		CONTA " + obj + "		");
		System.out.println("==============================================");
	}
}
