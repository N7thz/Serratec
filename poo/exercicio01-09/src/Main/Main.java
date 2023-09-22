package Main;

import java.time.LocalDate;
import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		Pessoa p = new Pessoa();
		
		p.setNome(input.nextLine());
		p.setCpf(input.nextLine());
		//p.setData_Nasc(input.nextLine());
		
		
	}
}
