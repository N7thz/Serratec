package principal;

import classes.Cliente;
import classes.ClienteDML;
import conexao.Conexao;
import conexao.DadosConexao;
import constantes.Util;
import dao.CreateDAO;

public class Principal {
	
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
			opcoes(menu());
		} else {
			System.out.println("Ocorreu um problema na criacao do banco de dados");
		}			
	}
	
	public static int menu() {
		System.out.println(Util.LINHA);
		System.out.println("      MENU");
		System.out.println(Util.LINHA);
		System.out.println("""
				Cadastro de clientes
				------------------------------
				1) Cadastrar
				2) Alterar
				3) Excluir
				4) Listar
				5) Sair
				------------------------------
				""");
		
		return Util.validarInteiro("Informe uma op��o:");
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
		ClienteDML.gravarCliente(con, SCHEMA, Cliente.cadastrarCliente());
	}
	
	public static void alterar() {
		
	}

	public static void excluir() {
	
	}
	
	public static void listar() {
		
	}

}
