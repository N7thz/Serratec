package arraylist;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Pessoa pessoa01 = new Pessoa("Carlos",22);
		Pessoa pessoa02 = new Pessoa("Maria",35);
		Pessoa pessoa03 = new Pessoa("João",57);
		
		ArrayList<Pessoa> cliente = new ArrayList<Pessoa>();
		
		cliente.add(pessoa01);
		cliente.add(pessoa02);
		cliente.add(pessoa03);
		 
		for (Pessoa dados : cliente) {
			System.out.println(dados.getIdade());
		}		
	}

	public static void arraylist_Conteudo() {
		//tamanho_fixo_de_5_posicoes
				String[] arrayEst = new String[5];
				//String[] nomes = {"Joao","Francisco","Carla","Joaquim","Guilherme"};
				arrayEst[0] = "Goku";
				arrayEst[1] = "Maria";
				arrayEst[2] = "Pedro";
				arrayEst[3] = "Bob Esponja";
				arrayEst[4] = "Jair";
				
				ArrayList<String> arrayDin = new ArrayList<String>();
				arrayDin.add("Jair");
				arrayDin.add("Bob Esponja");
				arrayDin.add("Pedro");
				arrayDin.add("Maria");
				arrayDin.add("Goku");
				
				System.out.println("Imprimindo valor estatico:");
				System.out.println();
				for (int i = 0; i < arrayEst.length; i++) {
					System.out.print(arrayEst[i] + "\t");
				}
				System.out.println();
				System.out.println();
				
				arrayDin.remove(2);
				
				System.out.println("Imprimindo valor Dinamico:");
				System.out.println();
				
				for (int i = 0; i < arrayDin.size(); i++) {
					System.out.print(arrayDin.get(i) + "\t");
				}
				
				System.out.println();
				System.out.println();
				
				System.out.println("forEach: ");
				System.out.println();
				for (String nome : arrayDin) {
					System.out.print(nome + "\t");
				}
				
				/*
				 * Tipos_primitivos ->	Wrapper Class
				 * 
				 * int				->	Integer
				 * float			->	Float
				 * double			->	Double
				 * char				->	Character
				 */
				
				
				//class nomeObjt = new Nome Obtj();
				//ArrayList<Tipo> nome = new ArrayList<Tipo()>;
	}
}
