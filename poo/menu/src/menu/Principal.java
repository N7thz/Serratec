package menu;

import constantes.Util;

public class Principal {
	public static void main(String[] args) {
		//menu();
		escolhaMenu();
		//chamaMetodos();
	}
	
	public static int menu() {
		System.out.println(Util.LINHAD);
		System.out.println("      	   MENU INICIAL");
		System.out.println(Util.LINHAD);
		System.out.println("""
				----------------------------------
				1) Cadastrar
				2) Alterar
				3) Excluir
				4) Listar
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static void escolhaMenu() {
		switch (menu()) {
			case 1: cadastrar(); break;
			case 2: alterar(); break;
			case 3: excluir(); break;
			case 4: listar(); break;
			case 5: System.out.println("Programa finalizado"); break;
			default: System.out.println("Opção invalida");
		}
	}
	
	public static int cadastrar() {
		System.out.println(Util.LINHAD);
		System.out.println("      CADASTRAR");
		System.out.println(Util.LINHAD);
		
		System.out.println("""
				----------------------------------
				1) Cliente
				2) Produto
				3) Pedido
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static int alterar() {
		System.out.println(Util.LINHAD);
		System.out.println("      ALTERAR");
		System.out.println(Util.LINHAD);
		
		System.out.println("""
				----------------------------------
				1) Cliente
				2) Produto
				3) Pedido
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static int excluir() {
		System.out.println(Util.LINHAD);
		System.out.println("      EXCLUIR");
		System.out.println(Util.LINHAD);
		
		System.out.println("""
				----------------------------------
				1) Cliente
				2) Produto
				3) Pedido
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static int listar() {
		System.out.println(Util.LINHAD);
		System.out.println("      EXCLUIR");
		System.out.println(Util.LINHAD);
		
		System.out.println("""
				----------------------------------
				1) Cliente
				2) Produto
				3) Pedido
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}

	
	public static void opcaoCadastrar() {
		switch (cadastrar()) {
			case 1: cadastrarCliente(); break;
			case 2: cadastrarProduto(); break;
			case 3: cadastrarPedido(); break;
			default: System.out.println("Valor invalido");
		}
	}
	
	public static void opcaoAlterar() {
		switch (alterar()) {
			case 1: alterarCliente(); break;
			case 2: alterarProduto(); break;
			case 3: alterarPedido(); break;
			default: System.out.println("Valor invalido");
		}
	}
	
	public static void opcaoExcluir() {
		switch (excluir()) {
			case 1: excluirCliente(); break;
			case 2: excluirProduto(); break;
			case 3: excluirPedido(); break;
			default: System.out.println("Valor invalido");
		}
	}
	
	public static void cadastrarCliente() {
		System.out.println("Cliente cadastrado");
	}
	
	public static void cadastrarProduto() {
		System.out.println("Produto cadastrado");
	}
	
	public static void cadastrarPedido() {
		System.out.println("Pedido cadastrado");
	}
	
	public static void alterarCliente() {
		System.out.println("Cliente alterado");
	}
	
	public static void alterarProduto() {
		System.out.println("Produto alterado");
	}
	
	public static void alterarPedido() {
		System.out.println("Pedido alterado");
	}
	
	public static void excluirCliente() {
		System.out.println("Cliente excluido");
	}
	
	public static void excluirProduto() {
		System.out.println("Produto excluido");
	}
	
	public static void excluirPedido() {
		System.out.println("Pedido excluido");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int opcoes(String op) {
		System.out.println(Util.LINHAD);
		System.out.println("      " + op);
		System.out.println(Util.LINHAD);
		
		System.out.println("""
				----------------------------------
				1) Cliente
				2) Produto
				3) Pedido
				5) Sair
				----------------------------------
				""");
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
}
