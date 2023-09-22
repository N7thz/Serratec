package classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Cliente extends Cadastro {
	private int idcliente;
	private int codigo; 

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public static Cliente cadastrarCliente() {
		Cliente c = new Cliente();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("Cadastro de cliente: ");
		System.out.println("-----------------------------------");
		
		System.out.println("");
		
		System.out.println("Informe o nome: ");
		String s = in.nextLine();
		c.setNome(s);
		
		System.out.println("Informe o CPF: ");
		s = in.nextLine();
		c.setCpf_cnpj(s);
	
		System.out.println("Informe o endereco: ");
		s = in.nextLine();
		c.setEndereco(s);
				
		
		System.out.println("Informe o Telefone: ");
		s = in.nextLine();
		c.setTelefone(s);
		
		LocalDateTime data_hora_atual = LocalDateTime.now();
		Instant instant = data_hora_atual.atZone(ZoneId.systemDefault()).toInstant();
		Date sqlDate = Date.from(instant);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dataHoraFormatada = data_hora_atual.format(formatter);
		c.setData_hora(dataHoraFormatada);
		
		return c;
	}

	
}
