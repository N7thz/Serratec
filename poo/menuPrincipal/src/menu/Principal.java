package menu;

import constantes.Util;

public class Principal {
    public static void main(String[] args) {
    	opcoes();
    	
    }
    
    public static int menu() {
		System.out.println(Util.LINHAD);
		System.out.println("      MENU");
		System.out.println(Util.LINHAD);
		System.out.println("""
		        ------------------------------
		        1) Cadastrar Cliente
		        2) Alterar Cliente
		        3) Excluir Cliente
		        4) Cadastrar Produto
		        5) Alterar Produto
		        6) Excluir Produto
		        7) Cadastrar Pedido
		        8) Alterar Pedido
		        9) Excluir Pedido
		        10) Lista de Produtos
		        11) Sair
		        ------------------------------
		        """);
		
		return Util.validarInteiro("Informe uma opção:");
    }
    
    public static void opcoes() {
    	switch (menu()) {
    		case 1: cadastrarCliente(); break;
    		case 2: alterarCliente(); break;
    		case 3: excluirCliente(); break;
    		case 4: cadastrarProduto(); break;
    		case 5: alterarProduto(); break;
    		case 6: excluirProduto(); break;
    		case 7: cadastrarPedido(); break;
    		case 8: alterarPedido(); break;
    		case 9: excluirPedido(); break;
    		case 10: ListaProdutos(); break;
    		case 11: System.out.println("Programa finalizado");
    		default: System.out.println("Opção inválida.");
    	}
    }
    
    public static void cadastrarCliente() {
    	System.out.println("cliente cadastrado");
    }
    
    public static void alterarCliente() {
    	System.out.println("cliente alterado");
    }
    
    public static void excluirCliente() {
    	System.out.println("cliente excluido");
    }
    
    public static void cadastrarProduto() {
    	System.out.println("produto cadastrado");
    }
    
    public static void alterarProduto() {
    	System.out.println("produto alterado");
    }
    
    public static void excluirProduto() {
    	System.out.println("produto excluido");
    }
    
    public static void cadastrarPedido() {
    	System.out.println("pedido cadastrado");
    }
    
    public static void alterarPedido() {
    	System.out.println("pedido alterado");
    }
    
    public static void excluirPedido() {
    	System.out.println("pedido excluido");
    }
    
    public static void ListaProdutos() {
    	System.out.println("lista de produtos");
    }
    
}