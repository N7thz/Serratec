import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		boolean controle = false;
		
		System.out.println("Informe o nome: ");
		pessoa.setNome(sc.nextLine());
		
		System.out.println("\nInforme o cpf: ");
		pessoa.setCpf(sc.nextLine());
		
		do {
			System.out.println("\nInforme uma data (dd/mm/aaaa): ");
			
			if (!pessoa.setDataNasc(sc.nextLine())) {
				controle = true;
			} else {
				controle = false;
			}
		} while (controle);

		System.out.println("\n\n"+pessoa);
		

	}

}
