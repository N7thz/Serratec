import java.util.ArrayList;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		cadastrarCompras();
	}
	
	public static void cadastrarCompras() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		boolean sair = false;
		double compra;
		int indice = 0;
		char resposta;
		ArrayList<Double> comprasList = new ArrayList<>();
		
		do {
			System.out.println("Digite o valor o valor da compra: ");
			compra = input.nextDouble();
			input.nextLine();
			
			if (compra <= 0) {
				System.out.println("O valor não é valido tente novamente.");
			} else {
				System.out.println("Compra adicionada com sucesso.");
				comprasList.add(indice, compra);
				indice++;
			}
			
			System.out.println("Deseja adicionar outra compra? [S/N]: ");
			resposta = input.next();
			System.out.println(resposta);
			if (resposta.charAt(0) == "N" || resposta.charAt(0) == "n" ) {
				//sair = true;
			}
			
		} while (sair);
		
		
	}
}
