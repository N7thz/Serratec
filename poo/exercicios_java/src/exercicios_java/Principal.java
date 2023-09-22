package exercicios_java;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		//exercicio_01();
		exercicio_02();
	}


	public static void exercicio_02() {
		int contador = 0;
		
		for (int i = 1000; i < 2000; i++) {
			if (i % 11 == 2) {
				System.out.print(" " + i + " ");
				contador++;
				if (contador%20 == 0) {
					System.out.println();
				}
			}
		}
	}


	public static void exercicio_01() {
	/*
	 1) Faça_um_programa_que_receba_a_idade_de_15_pessoas_e_que_calcule_e_mostre:
	 
		a) A_quantidade_de_pessoas_em_cada_faixa_etária;
		b) A_percentagem_de_pessoas_na_primeira_e_na_última_faixa_etária_com_relação_ao_total_de_pessoas: 
		
		Até_15_anos
		De_16_a_30_anos
		De_31_a_45_anos
		De_46_a_60_anos
		Acima_de_61_anos
	 */
		
		Scanner input = new Scanner(System.in);
		
		int idade[] = new int[15];
		int ate15 = 0;
		int de16a30 = 0;
		int de31a45 = 0;
		int de46a60 = 0;
		int acima61 = 0;
		int porcenFaixa15;
		int porcenFaixa61;
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Digite a " + (i + 1) + " Idade: " );
			idade[i] = input.nextInt();
			
			if (idade[i] < 0) {
				System.out.println("A idade digitada não é valida");
			} else if (idade[i] < 15){
				ate15++;
			} else if (idade[i] < 30) {
				de16a30++;
			} else if (idade[i] < 45) {
				de31a45++;
			} else if (idade[i] < 60) {
				de46a60++;
			} else {
				acima61++;
			}
		}
		
		porcenFaixa15 = ate15 * 100 / 3;
		porcenFaixa61 = acima61 * 100 / 3;
				
		System.out.println("Até 15 anos: " + ate15);
		System.out.println("De 16 a 30 anos: " + de16a30);
		System.out.println("De 31 a 45 anos: " + de31a45);
		System.out.println("De 46 a 60 anos: " + de46a60 );	
		System.out.println("Acima de 61 anos: " + acima61);
		System.out.println(porcenFaixa15 + "% das idades estão entre 0 e 15." );
		System.out.println("e " + porcenFaixa61 + "% das idades são maiores que 60.");
	}
}


