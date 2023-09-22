package classes;

import java.util.Scanner;
import constantes.Util;

public class Cliente extends Pessoa{
	private int idcliente;

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	public static Cliente cadastrarCliente() {
		Cliente c = new Cliente();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("Cadastro de cliente: ");
		System.out.println("-----------------------------------");
		
		System.out.println("");
		
		System.out.println("Informe o nome: ");
		String s = in.nextLine();
		c.setNome(s);
	
		System.out.println("Informe o endereco: ");
		s = in.nextLine();
		c.setEndereco(s);
		
		c.setDtNasc(Util.validarData("Informe a data de nascimento (dd/MM/yyyy): "));
		
		System.out.println("Informe o CPF: ");
		s = in.nextLine();
		c.setCpf(s);
		
		System.out.println("Informe o RG: ");
		s = in.nextLine();
		c.setRg(s);
		
		System.out.println("Informe o sexo: ");
		char ch = in.next().charAt(0);
		c.setSexo(ch);
		
		return c;
	}
	
	public static int localizarCliente() {
	
		System.out.println(Util.LINHA);
		System.out.println("Alteração de cliente");
		System.out.println(Util.LINHA);
		return Util.validarInteiro("Informe o código do cliente: ");
		
	}
	
	public static Cliente alterarCliente(Cliente c) {
		Scanner input = new Scanner(System.in);
		
		Util.escrever("Nome: ");
		c.setNome(input.nextLine());
		Util.escrever("CPF: ");
		c.setCpf(input.nextLine());
		
		return c;
	}
	
}
