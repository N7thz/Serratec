package teste01;

import java.util.Scanner;



public class classteste01 {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String nome = "Nathan";
		int idade;
		double numero;
		
		System.out.print("Olá, mundo!");
		
		System.out.println("Bem vindo," + nome);
		
		System.out.println("Informe a sua idade: ");
		//escreva("Informe a sua idade: ")
		idade = input.nextInt();
		//leia(idade)
		
		System.out.println("Informe o sobrenome: ");
		nome = nome + ' ' + input.next();
		
		System.out.println("A sua idade daqui a 10 anos será " + (idade + 10) );
		System.out.println("seu nome completo é " + nome);
	}
}
