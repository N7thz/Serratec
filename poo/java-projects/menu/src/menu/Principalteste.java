package menu;
import constantes.Util;

public class Principalteste {
    public static void main(String[] args) {
        //menu();
        //opcoes();
        //subMenu();
    	
        
    }

    public static int menu() {
 
            System.out.println(Util.LINHA);
            System.out.println("      MENU");
            System.out.println(Util.LINHA);
            System.out.println("""
                    ------------------------------
                    1) Cadastrar
                    2) Alterar
                    3) Excluir
                    4) Listar
                    5) Sair
                    ------------------------------
                    """);

          return Util.validarInteiro("Informe uma opção:");
        }
    public static int opcoesMenu(String op) {

        System.out.println(Util.LINHA);
        System.out.println("    "+op);
        System.out.println(Util.LINHA);
        System.out.println("""
                ------------------------------
                1) Cliente
                2) Produto
                3) Pedido
                5) Sair
                ------------------------------
                """);
        return Util.validarInteiro("Informe uma opção:");
    }
//opcoes_do_menu
           public static int opcoes() {
            switch (menu()){
	            case 1:opcoesMenu("CADASTRAR"); break;
	            case 2:opcoesMenu("ALTERAR"); break;
	            case 3:opcoesMenu("EXCLUIR"); break;
	            case 4:opcoesMenu("LISTAR"); break;
	            case 5: System.out.println("Sistema finalizado."); break;
	            default: System.out.println("Opção inválida");
            }
            return Util.validarInteiro("Informe uma opção:");
        }


       public static void menuTeste() {
			if (menu() == 1 && opcoesMenu("CADASTRAR") == 1) {
				cadastrarCliente();
			} else if (menu() == 1 && opcoesMenu("CADASTRAR") == 2) {
				alterarCliente();
			} else if (menu() == 1 && opcoesMenu("CADASTRAR") == 3) {
				excluirCliente();
			} else if (menu() == 2 && opcoesMenu("ALTERAR") == 1) {
				cadastrarProduto();
			} else if (menu() == 2 && opcoesMenu("ALTERAR") == 2) {
				alterarProduto();
			} else if (menu() == 2 && opcoesMenu("ALTERAR") == 3) {
				excluirProduto();
			} else if (menu() == 3 && opcoesMenu("EXCLUIR") == 1) {
				cadastrarPedido();
			} else if (menu() == 3 && opcoesMenu("EXCLUIR") == 2) {
				alterarPedido();
			} else if (menu() == 3 && opcoesMenu("EXCLUIR") == 3) {
				excluirPedido();
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
