package principal;

import java.util.Scanner;
import classes.Biblioteca;
import classes.Cliente;
import classes.Livro;
import conexao.Conexao;
import conexao.DadosConexao;
import contantes.Util;
import dao.ClienteDAO;
import dao.CreateDAO;
import dao.FuncionarioDAO;

public class Principal {
	public static Biblioteca b;
	public static Conexao con;
	public static DadosConexao dadosCon = new DadosConexao();
	public static final String BANCO = "trabalho_poo";
	public static final String SCHEMA = "sistema";
	public static final String LOCAL = "localhost";
	public static final String USUARIO = "postgres";
	public static final String SENHA = "123456";
	public static final String PORTA = "5432";
	public static final String BD = "PostgreSql";
	
	public static void main(String[] args) {
		
		dadosCon.setBanco(BANCO);
		dadosCon.setLocal(LOCAL);
		dadosCon.setUser(USUARIO);
		dadosCon.setSenha(SENHA);
		dadosCon.setPorta(PORTA);
		dadosCon.setBd(BD);
		
		if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
			con = new Conexao(dadosCon); 
			con.conect();
			b = new Biblioteca(con, SCHEMA);
			menuPrincipal();
		} else {
			System.out.println("Ocorreu um problema na criacao do banco de dados");
		}
	}
	
	public static void menuPrincipal() {
		int opcao = 0;
		
		do {			
			Util.escrever(Util.LINHAD);
			Util.escrever(Util.CABECALHO);
			Util.escrever(Util.LINHAD);
			Util.br();
			Util.escrever("Menu Principal");
			Util.escrever(Util.LINHA);
			Util.escrever("1- Cadastrar");
			Util.escrever("2- Alterar");
			Util.escrever("3- Imprimir");
			Util.escrever("4- Excluir");
			Util.escrever("5- Emprestar livro");
			Util.escrever("0- Sair");
			Util.escrever(Util.LINHA);
			
			opcao = Util.validarInteiro("Informe uma opcao: ");
			
			escolherMenu(opcao);
			
		} while (opcao != 0);
	}
	
	public static void escolherMenu(int opcao) {
		
		switch (opcao) {
		case 1: menuCadastrar(); break;
		case 2: menuAlterar(); break;
		case 3: menuImprimir(); break;
		case 4: menuExcluir(); break;
		case 5: emprestarLivro(); break;
		case 0: 
			Util.br();
			Util.escrever("Programa finalizado.");	
			break;
		default: Util.escrever("Opcao invalida");
		}
	}
	
	public static int menuPadrao(Util.CRUD tipoCrud) {
		int opcao = 0;
		
		do {
			Util.escrever(Util.LINHA);
			
			switch (tipoCrud) {
			case CADASTRAR: Util.escrever("CADASTRAR"); break;
			case ALTERAR: Util.escrever("ALTERAR"); break;
			case IMPRIMIR: Util.escrever("IMPRIMIR"); break;
			case EXCLUIR: Util.escrever("EXCLUIR"); break;
			}
					
			Util.escrever(Util.LINHA);
			Util.escrever("1- Cliente");
			Util.escrever("2- Funcionario");
			Util.escrever("3- Livro");
			Util.escrever("0- Voltar");
			Util.escrever(Util.LINHA);
			
			opcao = Util.validarInteiro("Informe uma opcao: ");			
			
			switch (tipoCrud) {
			case CADASTRAR: escolherMenuCadastrar(opcao); break;
			case ALTERAR: escolherMenuAlterar(opcao); break;
			case IMPRIMIR: escolherMenuImprimir(opcao); break;
			case EXCLUIR: escolherMenuExcluir(opcao); break;
			}
			
		} while (opcao != 0);
		
		return opcao;
	}
	
	public static void menuCadastrar() {
		menuPadrao(Util.CRUD.CADASTRAR);			
	}
	
	public static void escolherMenuCadastrar(int opcao) {		
		switch (opcao) {
		case 1: cadastrarCliente(); break;
		case 2: cadastrarFuncionario(); break;
		case 3: cadastrarLivro(); break;
		case 0: break;
		default: Util.escrever("Opcao invalida");
		}
	}
	
	public static void menuAlterar() {
		menuPadrao(Util.CRUD.ALTERAR);
	}
	
	public static void escolherMenuAlterar(int opcao) {		
		switch (opcao) {
		case 1: alterarCliente(); break;
		case 2: alterarFuncionario(); break;
		case 3: alterarLivro(); break;
		case 0: break;
		default: Util.escrever("Opcao invalida");
		}
	}
	
	public static void menuImprimir() {
		menuPadrao(Util.CRUD.IMPRIMIR);
	}
	
	public static void escolherMenuImprimir(int opcao) {		
		switch (opcao) {
		case 1: imprimirCliente(); break;
		case 2: imprimirFuncionario(); break;
		case 3: imprimirLivro(); break;
		case 0: break;
		default: Util.escrever("Opcao invalida");
		}
	}

	public static void menuExcluir() {
		menuPadrao(Util.CRUD.EXCLUIR);
	}
	
	public static void escolherMenuExcluir(int opcao) {		
		switch (opcao) {
		case 1: excluirCliente(); break;
		case 2: excluirFuncionario(); break;
		case 3: excluirLivro(); break;
		case 0: break;
		default: Util.escrever("Opcao invalida");
		}
	}
	
	public static void cadastrarCliente() {
		Cliente c = new Cliente();
		ClienteDAO cdao = new ClienteDAO(con, SCHEMA);
		
		c = b.cadastrarCliente();		
		
		int retorno = cdao.incluirCliente(c);
		
		if (retorno > 0) {
			Util.escrever("Cliente criado com sucesso.");
			b.adicionarCliente(c);
		}
	}
	
	public static void cadastrarFuncionario() {
		FuncionarioDAO f = new FuncionarioDAO(con, SCHEMA);
		
		if (f.incluir(b.adicionarFuncionario(b.cadastrarFuncionario())) > 0) {
			Util.br();
			Util.escrever("Funcionario criado com sucesso!");
			Util.br();
		}			
	}
	
	public static void cadastrarLivro() {
		b.adicionarLivro(b.cadastrarLivro());
	}
	
	public static void alterarCliente() {
		ClienteDAO cdao = new ClienteDAO(con, SCHEMA);
		Cliente c = b.localizarCliente();
		
		c.dadosPessoa();
		c.alterar();
		b.atualizarDadosCliente(c);
		cdao.alterarCliente(c);
	}
	
	public static void alterarFuncionario() {
		
	}
	
	public static void alterarLivro() {
		
	}
	
	public static void excluirCliente() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i = 0;
		ClienteDAO cdao = new ClienteDAO(con, SCHEMA);
		Cliente c = b.localizarCliente();
		
		if (c != null) {		
			Util.escrever("Deseja excluir o cliente: " + c.getNome());
			char s = input.next().charAt(0);
			
			if (s == 's' || s == 'S')
				i = cdao.excluirCliente(c);
			
			if (i > 0) {
				b.excluirCliente(c);
				System.out.println("Cliente excluido com sucesso.");
			}
		} else
			System.out.println("Cliente nao encontrado.");
	}
	
	public static void excluirFuncionario() {
		
	}
	
	public static void excluirLivro() {
		
	}
	
	public static void imprimirCliente() {
		//b.dadosEmprestimos();
		b.listarDadosClientes();
	}
	
	public static void imprimirFuncionario() {
		
	}
	
	public static void imprimirLivro() {
		b.listarDadosLivros();
	}
	
	public static void emprestarLivro() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Cliente c = b.localizarCliente();
		int quant;
		boolean emprestado, emprestar = false;
		char continuar = 'n';
		
		Util.escrever("Informe o titulo do livro: ");
		String titulo = input.nextLine();
		
		Livro v = b.localizarLivro(titulo, Livro.Localizar.TITULO);
		
		if (v != null) {
			do {
				quant = Util.validarInteiro("Informe a quantidade: ");			
				emprestado = b.emprestar(c, v, quant);
				
				if (!emprestado) {
					Util.escrever("Tentar outra quantidade? (s/n)");
					continuar = input.nextLine().charAt(0);
				}
				
				emprestar = continuar == 's' || continuar == 'S';
			
			} while (!emprestar);
		} else
			Util.escrever("Livro nao encontrado.");
	}
}
