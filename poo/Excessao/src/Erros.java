import java.util.InputMismatchException;
import java.util.Scanner;


public class Erros {
	public static void main(String[] args) {
		exemplo1();
		exemplo2();
	}
	
	public static void exemplo1() {
		Scanner input = new Scanner(System.in);
		
		int a = 10;
		int b = 0;
		int c = 0;
		boolean continua = false;
		
		do {
			try {
				System.out.println("Informe o b: ");
				b = input.nextInt();
				
				c = a / b;
				System.out.println("Resultado = " + c); 
				continua = false;
			} 				
			catch (ArithmeticException e) {
				continua = true;
				System.out.println("Não foi possível dividir por zero");
				System.out.println("Erro: " + e.getClass() + " - " + e.getMessage());
			}		
			catch(InputMismatchException e) {
				System.out.println("Valor inválido.");
				System.out.println("Tente novamente.");
				continua = true;
				input.nextLine();
			}
			catch (Exception e) {
				continua = true;
				System.out.println("Ocorreu um erro.");
				System.out.println("Erro: " + e.getClass() + " - " + e.getMessage());
			}
			
		} while(continua);
	}
	
	public static void exemplo2() {
		String fraseEntrada = null;
		String fraseSaida = null;
		
		
		try {
			fraseSaida = fraseEntrada.toUpperCase();
			System.out.println("Resultado: " + fraseSaida);
		} catch (NullPointerException e) {
			System.out.println("Falha ao transformar frase");
			System.out.println("Erro: " + e.getClass() + " - " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			System.out.println("Erro: " + e.getClass() + " - " + e.getMessage());
		}
		
		
	}
}