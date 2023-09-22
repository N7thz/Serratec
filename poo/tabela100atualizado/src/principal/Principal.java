package principal;

import java.util.Scanner;

import arquivo.ArquivoTxt;
import classes.Cliente;
import classes.ClienteDML;
import conexao.Conexao;
import conexao.DadosConexao;
import constantes.Util;
import dao.CreateDAO;
import classes.ListaClientes;


public class Principal {
	
	public static Conexao con;
	public static DadosConexao dadosCon = new DadosConexao();
	
	public static final String BANCO = "java";
	public static final String SCHEMA = "sistema";
	public static final String PATH = "C:\\temp\\";
	public static final String SFILE = "DadosConexao.ini";
	
	public static ListaClientes clientes; 
	
	public static void main(String[] args) {
		
		if (configInicial()) {
			if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
				con = new Conexao(dadosCon); 
				con.conect();
				clientes = new ListaClientes(con, SCHEMA);
				opcoes(menu());
			} else {
				System.out.println("Ocorreu um problema na criacao do banco de dados");
			}	
		} else
			System.out.println("Não foi possível executar o sistema.");
	}
	
	public static boolean configInicial() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		ArquivoTxt conexaoIni = new ArquivoTxt(PATH+SFILE);
		boolean abrirSistema = false;
		
		if (conexaoIni.criarArquivo()) {
			if (conexaoIni.alimentaDadosConexao()) {
				dadosCon = conexaoIni.getData();
				abrirSistema = true;
			} else {
				conexaoIni.apagarArquivo();
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
				
				if (conexaoIni.criarArquivo()) {
					conexaoIni.escreverArquivo("bd=PostgreSql");
					conexaoIni.escreverArquivo("local="+local);
					conexaoIni.escreverArquivo("porta="+porta);
					conexaoIni.escreverArquivo("usuario="+usuario);
					conexaoIni.escreverArquivo("senha="+senha);
					conexaoIni.escreverArquivo("banco="+banco);
					
					if (conexaoIni.alimentaDadosConexao()) {
						dadosCon = conexaoIni.getData();
						abrirSistema = true;
					} else System.out.println("Não foi possível efetuar a configuração.\nVerifique");	
				}
			}
		} else
			System.out.println("Houve um problema na criação do arquivo de configuração.");
		
		return abrirSistema;
	}
	
	public static int menu() {
		System.out.println(Util.LINHA);
		System.out.println("      MENU");
		System.out.println(Util.LINHA);	
		System.out.println("Cadastro de clientes");
		System.out.println("------------------------------");
		System.out.println("1) Cadastrar");
		System.out.println("2) Alterar");
		System.out.println("3) Excluir");
		System.out.println("4) Listar");
		System.out.println("5) Sair");
		System.out.println("------------------------------");		
		
		return Util.validarInteiro("Informe uma opção:");
	}
	
	public static void opcoes(int opcao) {
		switch (opcao) {
		case 1: cadastrar(); break;
		case 2: alterar(); break;
		case 3: excluir(); break;
		case 4: listar(); break;
		case 5: System.out.println("Sistema finalizado."); break;
		default: System.out.println("Opção inválida");
		}
	}
	
	public static void cadastrar() {
		Cliente c = Cliente.cadastrarCliente();
		
		ClienteDML.gravarCliente(con, SCHEMA, c);
		clientes.adicionarClienteLista(c);
	}
	
	public static void alterar() {
		Cliente c = clientes.localizarCliente(Cliente.localizarCliente("Alteração de cliente"));
		
		if (!(c == null)) {
			Cliente.alterarCliente(c);
		
			ClienteDML.alterarCliente(con, SCHEMA, c);
		} else
			System.out.println("Cliente não localizado.");
	}

	public static void excluir() {
		Cliente c = clientes.localizarCliente(Cliente.localizarCliente("Exclusão de cliente")); 
		
		if (!(c == null)) {
			clientes.excluirCliente(c);
			ClienteDML.excluirCliente(con, SCHEMA, c);
		} else
			System.out.println("Cliente não localizado.");
	}
	
	public static void listar() {
		clientes.imprimirClientes();
	}

}
