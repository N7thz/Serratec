package principal;

import java.util.Scanner;

import arquivo.ArquivoTxt;
import conexao.Conexao;
import conexao.DadosConexao;
import dao.CreateDAO;

public class Principal {
	
	//classe_estatica_para_nao_ser_preciso_objeto
	public static Conexao con;
	
	//cria_objeto_da_classe_dados_conexao
	public static DadosConexao dadosCon = new DadosConexao();
	
	//costantes_do_banco
	public static final String BANCO = "grupo01";
	public static final String SCHEMA = "sistema";
	public static final String PATH = "C:\\temp\\";
	public static final String SFILE = "grupo01.ini";
	
	public static void main(String[] args) {
		
		if (configInicial()) {
			if (CreateDAO.createBD(BANCO, SCHEMA, dadosCon)) {
				//cria_um_objeto_do_tipo_conexao ( basicamente_cria_uma_conexao )
				con = new Conexao(dadosCon); 
				con.conect();
			} else {
				System.out.println("Ocorreu um problema na criacao do banco de dados");
			}	
		} else
			System.out.println("Não foi possivel executar o sistema.");
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
}
