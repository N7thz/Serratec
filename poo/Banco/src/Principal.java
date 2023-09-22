import java.util.Scanner; 

public class Principal {
	public static void main(String[] args) {
		conta();
		balanco();

	}
	
	public static void balanco() {
		Balanco balancoTrimestral = new Balanco(10000, 12000, 15000);
		Balanco balancoSemestral = new Balanco(	balancoTrimestral.getJaneiro(),
												balancoTrimestral.getFevereiro(), 
												balancoTrimestral.getMarco(), 
												16000, 17000, 180000);
	}
	
	public static void conta() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		Conta conta1;
		Conta conta2 = new Conta(1211, "Ricardo Oliveira", 1000);
		
		conta1 = new Conta(85251, "João da Silva", 5000);
		
		//conta2.setSaldo(5);
		
		//Conta conta3 = new Conta();

		//conta1.numero = 1211;
		//conta1.titular = "Ricardo Oliveira";
		//conta1.saldo = 1000;

		//conta1.setNumero(1212);
		//conta1.setTitular("Ricardo");
		//conta1.setSaldo(0);
		
		conta1.imprimirDados();
		conta1.imprimirSaldo();
			
		//double saldo = conta1.verificaSaldo();
		
		System.out.println("Informe o valor a sacar: ");
		double saque = input.nextDouble();
		
		if (!conta1.sacar(saque)) {
			System.out.println("Saque nï¿½o autorizado.");
		}
		
		conta1.imprimirSaldo();
		
		System.out.println("Informe o valor a transferir: ");
		double transf = input.nextDouble();
		conta1.transferir(conta2, transf);
		
		//conta1.saldo = 0; 
		conta1.depositar(500);
		conta1.imprimirSaldo();
		conta2.imprimirSaldo();
	}
	
	
}
