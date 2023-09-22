package modelo;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Pessoa p1;
		Pessoa p2;
		Pessoa p3;
		
		p1 = cadastrarPessoa();
		p2 = cadastrarPessoa();
		p3 = cadastrarPessoa();
		
		imprimirPessoa(p1);
		imprimirPessoa(p2);
		imprimirPessoa(p3);
		
		int num = 10;
		String texto = "fgfsdfsaf";
		
	}
	
	public static Pessoa cadastrarPessoa() {
		Scanner input = new Scanner(System.in);
		
		Pessoa p = new Pessoa();
		
		Telefone celular;
		Telefone telres;
		Telefone teltrab;
		
		Endereco endres;
		Endereco endent;
		Endereco endtrab;
		
		System.out.println("""
				=============================== 
						CADASTRO DE PESSOA
				===============================				
				""");
		System.out.println("Nome: ");
		String nome = input.nextLine();
		System.out.println("CPF: ");
		String cpf = input.nextLine();
		
		System.out.println("""
				------------------------------
							Telefones
				""");
		
		celular = cadastrarTelefone("Celular");
		telres = cadastrarTelefone("Residencial");	
		teltrab = cadastrarTelefone("Trabalho");
				
		System.out.println("""
				------------------------------
							Endereços
				""");		

		endres = cadastrarEndereco("Residencial");
		endent = cadastrarEndereco("Entrega");
		endtrab = cadastrarEndereco("Cobrança");

		p.setNome(nome);
		p.setCpf(cpf);
		p.setTel_celular(celular);
		p.setTel_residencial(telres);
		p.setTel_trabalho(teltrab);
		p.setEnd_residencial(endres);
		p.setEnd_entrega(endent); 
		p.setEnd_cobranca(endtrab);
		return p;
	}
	
	public static Telefone cadastrarTelefone(String tipo) {
		Scanner input = new Scanner(System.in);
		
		Telefone t = new Telefone();
		
		System.out.println(tipo +": ");		 
		t.setNumero(input.nextLine());
		t.setTipo(tipo);
		
		return t;
	}
	
	public static Endereco cadastrarEndereco(String tipo) {
		Scanner input = new Scanner(System.in);
		
		Endereco e = new Endereco();
		
		System.out.println(tipo + ": ");
		System.out.println("Logradouro: ");
		e.setLogradouro(input.nextLine());
		System.out.println("Número: ");
		e.setNumero(input.nextLine());
		System.out.println("Bairro: ");
		e.setBairro(input.nextLine());
		System.out.println("Cidade: ");
		e.setCidade(input.nextLine());
		System.out.println("CEP: ");
		e.setCep(input.nextLine());		
		
		return e;
	}
	
	public static void imprimirPessoa(Pessoa p) {
		p.dadosPessoa();
	}
}
