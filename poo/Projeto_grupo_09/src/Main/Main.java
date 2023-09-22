package Main;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import classes.*;
import arquivo.ArquivoTxt;
import conexao.Conexao;
import conexao.DadosConexao;
import constantes.Util;
import dao.CreateDAO;


public class Main {
	//classe_estatica_para_nao_ser_preciso_objeto
	public static Conexao con;
	
	//cria_objeto_da_classe_dados_conexao
	public static DadosConexao dadosCon = new DadosConexao();
	
	//costantes_do_banco
	public static final String BANCO = "grupo01";
	public static final String SCHEMA = "sistema";
	public static final String PATH = "C:\\temp\\";
	public static final String SFILE = "grupo01.ini";
	
	public static ListasProdutos produtos;
	public static ListaClientes clientes;
	public static ListaPedidos pedidos;
	
	public static void main(String[] args) {
	
		if (configInicial()) {
			if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
				//cria_um_objeto_do_tipo_conexao ( basicamente_cria_uma_conexao )
				con = new Conexao(dadosCon); 
				con.conect();
				clientes = new ListaClientes(con, SCHEMA);
				produtos = new ListasProdutos(con, SCHEMA);
				pedidos = new ListaPedidos(con, SCHEMA);
			} else {
				System.out.println("Ocorreu um problema na criacao do banco de dados");
			}	
		} else
			System.out.println("Não foi possivel executar o sistema.");
		
		
		nossa_empresa();
		menu();
	}
	
	public static void nossa_empresa() {
		LocalDateTime data_hora_atual = LocalDateTime.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dataHoraFormatada = data_hora_atual.format(formatter);
		
		Empresa Grupo_1 = new Empresa("Grupo 1","12345678900","rua A","(21)94002-8922","grupo01@gmail.com",dataHoraFormatada,"mC BURGER");
		
	}
	
	public static boolean configInicial() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//cria_um_objeto_do_tipo_arquivo_com_o_caminho_e_nome_das_constantes
		ArquivoTxt conexaoIni = new ArquivoTxt(PATH+SFILE);
		boolean abrirSistema = false;
		
		//se_o_arquivo_foi_criado_alimenta_o_arquivo
		if (conexaoIni.criarArquivo()) {
			if (conexaoIni.alimentaDadosConexao()) {
				dadosCon = conexaoIni.getData();
				abrirSistema = true;
			//se_o_abrirSistema_for_true_o_arquivo_foi_alimentado_senao_apaga_o_arquivo_e_cria_outro
			} else {
				conexaoIni.apagarArquivo();
				//dados_do_novo_arquivo
				System.out.println("Arquivo de configuração de conexão:\n");
				System.out.println("Local: ");
				String local = input.nextLine();
				System.out.println("Porta: ");
				String porta = input.nextLine();
				System.out.println("Usuário: ");
				String usuario = input.nextLine();
				System.out.println("Senha: ");
				String senha = input.nextLine();
				System.out.println("Database: ");
				String banco = input.nextLine();
				
				//se_o_novo_arquivo_foi_criado_Preeche_ele_com_os_dados
				if (conexaoIni.criarArquivo()) {
					conexaoIni.escreverArquivo("bd=PostgreSql");
					conexaoIni.escreverArquivo("local="+local);
					conexaoIni.escreverArquivo("porta="+porta);
					conexaoIni.escreverArquivo("usuario="+usuario);
					conexaoIni.escreverArquivo("senha="+senha);
					conexaoIni.escreverArquivo("banco="+banco);
					
					//mesmo_if_da_linha_57_que_testa_se_o_arquivo_foi_alimentado 
					if (conexaoIni.alimentaDadosConexao()) {
						dadosCon = conexaoIni.getData();
						abrirSistema = true;
						//se_nada_foi_possivel_printa_a_mensagem_abaixo
					} else System.out.println("Não foi possivel efetuar a configuração.\nVerifique");	
				}
			}
		//se_nada_foi_possivel_printa_a_mensagem_abaixo	
		} else
			System.out.println("Houve um problema na criação do arquivo de configuração.");
		
		return abrirSistema;
	}
	
	public static void cadastrarProduto() {
		Produto p = Produto.cadastrarProduto();
		
		ProdutoDML.gravarProduto(con, SCHEMA, p);
		produtos.adicionarProdutoLista(p);
		opcoesProduto();
	}
	
	public static void cadastrarCliente() {
		Cliente c = Cliente.cadastrarCliente();
		
		ClienteDML.gravarCliente(con, SCHEMA, c);
		clientes.adicionarClienteLista(c);
		opcoesCliente();		
	}
	
	public static void alterarCliente() {
        Cliente c = clientes.localizarCliente(Cliente.localizarCliente
		("Alteração de cliente"));
        
        if(!(c == null)) {
        	Cliente.alterarCliente(c);
        	ClienteDML.alterarCliente(con, SCHEMA, c);
        } else
        	System.out.println("Cliente não localizado!");
    }

    public static void excluirCliente() {
    	Cliente c = clientes.localizarCliente(Cliente.localizarCliente
    			("Exclusão de cliente"));
    	        
    	        if(!(c == null)) {
    	        	clientes.excluirCliente(c);
    	        	ClienteDML.excluirCliente(con, SCHEMA, c);
    	        }else
    	        	System.out.println("Cliente não localizado!");
    }
    
    public static void listarCliente() {
    	clientes.imprimirClientes();
    	
    }

    public static void alterarProduto() {
    	Produto p = produtos.localizarProduto(Produto.localizarProduto
    			("Alteração de produto"));
    	        
    	        if(!(p == null)) {
    	        	Produto.alterarProduto(p);
    	        	ProdutoDML.alterarProduto(con, SCHEMA, p);
    	        }else
    	        	System.out.println("Produto não localizado!");
        
    }

    public static void excluirProduto() {
    	Produto p = produtos.localizarProduto(Produto.localizarProduto
    			("Exclusão de produto"));
    	        
    	        if (!(p == null)) {
    	        	produtos.excluirProduto(p);
    	        	ProdutoDML.excluirProduto(con, SCHEMA, p);
    	        } else
    	        	System.out.println("Produto não localizado!");
    }
    
    public static void listarProduto() {
       produtos.imprimirProdutos();
    }

    public static void cadastrarPedido() {
    	Scanner input = new Scanner(System.in);
    	int r;
    	
		Cliente c = clientes.localizarCliente(Cliente.localizarCliente("Digite o id do cliente: "));
		        
        if (!(c == null)) {
        		Pedido pe = Pedido.cadastrarPedido();
            	PedidoDML.gravarPedido(con, SCHEMA, pe);
        		opcoesPedido();
        } else {
        	System.out.println("Cliente não localizado!");
        	System.out.println("Digite [1] para cadastrar um novo cliente: ");
        	r = input.nextInt();
        	if (r == 1) {
        		cadastrarCliente();
        	} else {
        		menu();
        	}
        }     	
    }

    public static void alterarPedido() {
        System.out.println("pedido alterado");
    }

    public static void excluirPedido() {
        System.out.println("pedido excluido");
    }

    public static void listarPedido() {
        System.out.println("lista de pedidos");
    }
	
    
    static void menu() {	
		Scanner input = new Scanner(System.in);
		int opcao;
		do {
			System.out.println(Util.LINHAD);
			System.out.println("	  MENU INICIAL");
			System.out.println(Util.LINHAD);
			System.out.println("[1] Produto");
			System.out.println("[2] Cliente");
			System.out.println("[3] Pedido");
			System.out.println("[4] Sair");
			System.out.println("");
			opcao = input.nextInt();
			
			switch(opcao) {
			case 1:				
				opcoesProduto();
				break;
			case 2:				
				opcoesCliente();
				break;
			case 3:				
				opcoesPedido();
				break;
			case 4:
				System.out.println("Cadastro encerrado.");
				break;
			default:
				System.out.println("ERRO!!! Tente novamente.");
				break;
			}			
		}while(opcao != 4);
	}
    
    public static void opcoesProduto() {
    	Scanner input = new Scanner(System.in);
    	
    	
    	int opcao;
    	
    	System.out.println("""
				----------------------------------
				       PRODUTO
				----------------------------------

				[1] Cadastrar Produto
				[2] Alterar Produto
				[3] Excluir Produto
				[4] Listar Produto
				[5] Menu inicial

                """);
    	System.out.println("");
		opcao = input.nextInt();
		
		switch(opcao) {
		case 1:				
			cadastrarProduto();
			break;
		case 2:				
			alterarProduto();
			break;
		case 3:				
			excluirProduto();
			break;
		case 4:				
			listarProduto();
			break;
		case 5:
			menu();
			break;
		default:
			System.out.println("[ERRO!!!] Tente novamente.");
			break;
		}			
	while(opcao != 4);
    }

	public static void opcoesCliente(){
		Scanner input = new Scanner(System.in);
    	int opcao;
    	System.out.println("""
				----------------------------------
				       CLIENTE
				----------------------------------

				[1] Cadastrar Cliente
				[2] Alterar Cliente
				[3] Excluir Cliente
				[4] Listar Cliente
				[5] Menu inicial

                """);
    	System.out.println("");
		opcao = input.nextInt();
		
		switch(opcao) {
		case 1:				
			cadastrarCliente();
			break;
		case 2:				
			alterarCliente();
			break;
		case 3:				
			excluirCliente();
			break;
		case 4:				
			listarCliente();
			opcoesCliente();
			break;
		case 5:
			menu();
			break;
		default:
			System.out.println("[ERRO!!!] Tente novamente.");
			break;
		}			
	while(opcao != 4);
	}
	
	public static void opcoesPedido(){
		Scanner input = new Scanner(System.in);
    	int opcao;
    	System.out.println("""
				----------------------------------
				       PEDIDO
				----------------------------------

				[1] Cadastrar Pedido
				[2] Alterar Pedido
				[3] Excluir Pedido
				[4] Listar Pedido
				[5] Menu inicial

                """);
    	System.out.println("");
		opcao = input.nextInt();
		
		switch(opcao) {
		case 1:				
			cadastrarPedido();
			break;
		case 2:				
			alterarPedido();
			break;
		case 3:				
			excluirPedido();
			break;
		case 4:				
			listarPedido();
			break;
		case 5:
			menu();
			break;
		default:
			System.out.println("[ERRO!!!] Tente novamente.");
			break;
		}			
	while(opcao != 4);
	}
	

}







