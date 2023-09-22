/**
 * 
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import conexao.Conexao;
import contantes.Util;
import dao.ClienteDAO;
import dao.LivroDAO;

/**
 * Classe que representa os dados da Biblioteca com seus funcionarios e clientes e livros disponiveis
 * Permite representar os emprestimos dos livros.
 * 
 *  
 * @author Ricardo de Jesus Oliveira
 *
 */
public class Biblioteca {	
	
	/**
	 * classe que herda a classe Livro e acrescenta um atributo de quantidade emprestada
	 * 
	 * @author ricardo.dsn.shop
	 *
	 */
	private class LivroEmprestado extends Livro{
		private int quantEmprestimo;

		public int getQuantEmprestimo() {
			return quantEmprestimo;
		}
		
		private void setQuantEmprestimo(int quantEmprestimo) {
			this.quantEmprestimo = quantEmprestimo;
		}		
	}
	
	/**
	 * classe que representa um cliente, herdando da classe Cliente e adiciona um
	 * ArrayList da classe LivroEmprestado
	 * 
	 * Permite representar os livros que um cliente pegou emprestado na Biblioteca.
	 * 
	 * @author ricardo.dsn.shop
	 *
	 */
	private class Cliente extends classes.Cliente {	
		private ArrayList<LivroEmprestado> livroEmprestado = new ArrayList<>();
	}
	
	/**
	 * Atributo que representa uma lista dos funcionarios da Biblioteca
	 */
	private ArrayList<Funcionarios> funcionario = new ArrayList<>();
	/**
	 * Atributo que representa uma lista dos clientes da biblioteca
	 */
	private ArrayList<Cliente> cliente = new ArrayList<>();
	/**
	 * Atributo que representa uma lista dos livros da Biblioteca
	 */
	private ArrayList<Livro> livro = new ArrayList<>();
	
	private Conexao con; 
	private String schema;
	
	/**
	 * Construtor da Biblioteca.
	 * Carrega a lista de cliente e de livros do banco de dados.
	 * 
	 * @author Ricardo
	 * 
	 * @param 	con
	 * 			O objeto de conexao com o banco de dados
	 * 
	 * @param 	schema
	 * 			A String que contem o nome do schema da base de dados
	 */
	public Biblioteca(Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaClientes();
		carregarListaLivros();
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param 	c 
	 * 			O objeto Cliente com seus dados. Sera adicionado na lista de clientes
	 * 
	 * @param 	livro - 
	 * 			O objeto Livro e seus dados. Sera adicionado na lista de livros 
	 * 			emprestados ao cliente
	 * 
	 * @param 	quant
	 * 			A quantidade do livro a ser emprestado
	 * 
	 * @return 	boleean true se o emprestimo foi concedido e false para emprestimo nao concedido
	 */
	public boolean emprestar(classes.Cliente c, Livro livro, int quant) {
		boolean retorno = false;
		
		if (livro.getQuantidade() > 0 && livro.getQuantidade() >= quant) {
			adicionarLivro(c, livro, quant);
			retorno = true;
		} else {
			if (livro.getQuantidade() == 0) {
				System.out.println("Este livro nao esta disponivel para emprestimo.");
			} else {
				System.out.println("A quantidade solicitada e superior a quantidade disponivel.");
			}
		}
		return retorno;	
	}
	
	public void devolver(Livro livro, int quant) {
		livro.setQuantidade(livro.getQuantidade() + quant);
	}
	
	public void dadosEmprestimos() {
		System.out.println("\n\nDados dos emprestimos:");
		
		for (Cliente cliente2: cliente) {
			System.out.println("------------------------------");
			System.out.printf("Nome do cliente: %s", cliente2.getNome());
			System.out.printf("%nCPF: %s%n", cliente2.getCpf());
			System.out.println("------------------------------");
			System.out.println("       Livros");
			System.out.println("------------------------------");
			
			for (Biblioteca.LivroEmprestado liv : cliente2.livroEmprestado) {
				System.out.printf("Titulo: %s%n", liv.getTitulo());
				System.out.printf("Autor: %s%n", liv.getAutor());
				System.out.printf("Editora: %s%n", liv.getEditora());
				System.out.printf("ISBN: %s%n", liv.getIsbn());
				System.out.printf("Quantidade emprestada: %d%n", liv.getQuantEmprestimo());
			}
		}
	}
	
	private void adicionarLivro(Pessoa c, Livro l, int quant) {
		Cliente cl = new Cliente();
		LivroEmprestado le = new LivroEmprestado();
		boolean existeCliente = false;
		int index = 0;
		
		le.setTitulo(l.getTitulo());
		le.setAutor(l.getAutor());
		le.setEditora(l.getEditora());
		le.setIsbn(l.getIsbn());
		le.setNumPaginas(l.getNumPaginas());
		le.setQuantEmprestimo(quant);
		
		for (Cliente cliente2 : cliente) {
			if (cliente2.getCpf() == c.getCpf()) {
				existeCliente = true;
				index = cliente.lastIndexOf(cliente2);
				break;
			}
		}
		
		if (!existeCliente) {
			cl.setNome(c.getNome());
			cl.setDtNasc(c.getDtNasc());
			cl.setCpf(c.getCpf());
			cl.setRg(c.getRg());
			cl.setSexo(c.getSexo());
			cl.livroEmprestado.add(le);
			
			cliente.add(cl);
		} else {
			cliente.get(index).livroEmprestado.add(le);
		}
	}

	
	public ArrayList<Funcionarios> getFuncionarios() {
		return funcionario;
	}

	
	public Funcionarios adicionarFuncionario(Funcionarios funcionario) {
		this.funcionario.add(funcionario);
		
		return funcionario;
	}
	
	public classes.Cliente adicionarCliente(classes.Cliente cliente) {
		Cliente c = new Cliente();
		
		c.setNome(cliente.getNome());
		c.setEndereco(cliente.getEndereco());
		c.setCpf(cliente.getCpf());
		c.setDtNasc(cliente.getDtNasc());
		c.setRg(cliente.getRg());
		c.setSexo(cliente.getSexo());
		
		this.cliente.add(c);
		
		return cliente;
	}	
	
	public void listarDadosClientes() {
 		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("\n==================================================================================");
		System.out.println("                               LISTAGEM DE CLIENTES                               ");
		System.out.println("==================================================================================");
		System.out.println("Nome\t\t\t\tCPF\t\tRG\t\t\tDt.Nasc.");
		System.out.println("----------------------------------------------------------------------------------");
					
		for (Cliente c : cliente) {
			System.out.printf("%-25s\t", c.getNome());
			System.out.printf("%-15s\t", c.getCpf());
			System.out.printf("%-10s\t\t", c.getRg());
			if (c.getDtNasc() != null)
				System.out.printf("%s", c.getDtNasc().format(dtf));
			System.out.println();
		}

		System.out.println();
	}
	
	public void listarDadosLivros() {
		System.out.println("\n=================================================================================================");
		System.out.println("                                      LISTAGEM DE LIVROS                               ");
		System.out.println("=================================================================================================");
		System.out.println("Titulo\t\t\t\tAutor\t\t\tEditora\t\t\tNr.Pag.\tQt.Disp.");
		System.out.println("-------------------------------------------------------------------------------------------------");
		
		int tam;
		for (Livro l : livro) {
			tam = l.getTitulo().length();
			
			if (tam > 25)
				tam = 24;
			System.out.printf("%-25s\t", l.getTitulo().substring(0, tam));
			System.out.printf("%-18s\t", l.getAutor());
			System.out.printf("%-18s\t", l.getEditora());
			System.out.printf("%6s\t", l.getNumPaginas());
			System.out.printf("%6s\t", l.getQuantidade());
			System.out.println();
		}

		System.out.println();
	}
	
 	public classes.Cliente cadastrarCliente() {
		classes.Cliente c = new classes.Cliente();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println(Util.LINHA);
		System.out.println("Cadastro de cliente: ");
		System.out.println(Util.LINHA);
		
		Util.br();
		
		System.out.println("Informe o nome: ");
		String s = in.nextLine();
		c.setNome(s);
	
		System.out.println("Informe o endereco: ");
		s = in.nextLine();
		c.setEndereco(s);
		
		c.setDtNasc(Util.validarData("Informe a data de nascimento (dd/MM/yyyy): "));
		
		System.out.println("Informe o CPF: ");
		s = in.nextLine();
		c.setCpf(s);
		
		System.out.println("Informe o RG: ");
		s = in.nextLine();
		c.setRg(s);
		
		System.out.println("Informe o sexo: ");
		char ch = in.next().charAt(0);
		c.setSexo(ch);
		
		//in.close();
		
		return c;
	}
	
	public Funcionarios cadastrarFuncionario() {
		Funcionarios f = new Funcionarios();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println(Util.LINHA);
		System.out.println("Cadastro de funcionario: ");
		System.out.println(Util.LINHA);
		
		Util.br();
		
		System.out.println("Informe o nome: ");
		String s = in.nextLine();
		f.setNome(s);
	
		System.out.println("Informe o endereco: ");
		s = in.nextLine();
		f.setEndereco(s);
				
		System.out.println("Informe o CPF: ");
		s = in.nextLine();
		f.setCpf(s);
		
		System.out.println("Informe o RG: ");
		s = in.nextLine();
		f.setRg(s);
		
		System.out.println("Informe o sexo: ");
		char ch = in.nextLine().charAt(0);
		f.setSexo(ch);
		
		System.out.println("Informe o cargo: ");
		s = in.nextLine();
		f.setCargo(s);
		
		System.out.println("Informe o numero da CTPS: ");
		s = in.nextLine();
		f.setCtps(s);
		
		System.out.println("Informe o valor do salario: ");
		double d = in.nextDouble();
		f.setSalario(d);
		
		return f;
	}
	
	public void adicionarLivro(Livro livro) {
		this.livro.add(livro);
	}
	
	private void carregarListaLivros() {
		LivroDAO ldao = new LivroDAO(con, schema);
		
		ResultSet tabela = ldao.carregarLivros();
		this.livro.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.livro.add(dadosLivro(tabela));				
			}
			
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public Livro cadastrarLivro() {
		Livro livro = new Livro();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println(Util.LINHA);
		System.out.println("Cadastro de livro: ");
		System.out.println(Util.LINHA);
		
		Util.br();
		
		System.out.println("Informe o titulo: ");
		String s = in.nextLine();
		livro.setTitulo(s);
		
		System.out.println("Informe o autor: ");
		s = in.nextLine();
		livro.setAutor(s);
		
		System.out.println("Informe a editora: ");
		s = in.nextLine();
		livro.setEditora(s);
		
		System.out.println("Informe o ISBN: ");
		s = in.nextLine();
		livro.setIsbn(s);
		
		int i = Util.validarInteiro("Informe o numero de paginas: ");
		livro.setNumPaginas(i);
		
		i = Util.validarInteiro("Informe a quantidade: ");
		livro.setQuantidade(i);
		
		//in.close();
		
		return livro;
	}
	
	private Cliente dadosCliente(ResultSet tabela) { 
		Cliente c = new Cliente();
		String dtNasc; 
		
		try {
			dtNasc = tabela.getString("dtnasc");
			if (dtNasc != null)
				c.setDtNasc(LocalDate.parse(dtNasc));
			c.setNome(tabela.getString("nome"));
			c.setEndereco(tabela.getString("endereco"));
			c.setCpf(tabela.getString("cpf"));			
			c.setRg(tabela.getString("rg"));
			c.setIdcliente(tabela.getInt("idcliente"));
			return (Cliente) c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Livro dadosLivro(ResultSet tabela) {
		Livro l = new Livro();
			
		try {
			l.setTitulo(tabela.getString("titulo"));
			l.setAutor(tabela.getString("autor"));
			l.setEditora(tabela.getString("editora"));			
			l.setIsbn(tabela.getString("isbn"));
			l.setNumPaginas(tabela.getInt("nrpaginas"));
			l.setQuantidade(tabela.getInt("quantidade"));
			l.setIdlivro(tabela.getInt("idlivro"));
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void carregarListaClientes() {
		ClienteDAO cdao = new ClienteDAO(con, schema);
		
		ResultSet tabela = cdao.carregarClientes();
		this.cliente.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.cliente.add(dadosCliente(tabela));				
			}
			
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public classes.Cliente localizarCliente() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		classes.Cliente cl = new classes.Cliente();
		
		int i = -1;
				
		System.out.println("Informe o CPF do cliente: ");
		String s = in.next();
		
		for (Cliente c : cliente) {
			if (c.getCpf().equals(s)) {
				i = cliente.lastIndexOf(c);
				break;
			}
		}
		
		if (i >= 0) {
			cl.setNome(cliente.get(i).getNome());
			cl.setCpf(cliente.get(i).getCpf());
			cl.setEndereco(cliente.get(i).getEndereco());
			cl.setDtNasc(cliente.get(i).getDtNasc());
			cl.setIdcliente(cliente.get(i).getIdcliente());
			cl.setRg(cliente.get(i).getRg());
			cl.setSexo(cliente.get(i).getSexo());
			
			return cl;	
		} else
			return null;
	}
	
	public void atualizarDadosCliente(classes.Cliente cl) {
		int i = 0;
		
		for (Cliente c : cliente) {
			if (c.getIdcliente() == cl.getIdcliente()) {
				i = cliente.lastIndexOf(c);
				break;
			}
		}
		
		cliente.get(i).setNome(cl.getNome());
		cliente.get(i).setCpf(cl.getCpf());
		cliente.get(i).setEndereco(cl.getEndereco());
		cliente.get(i).setDtNasc(cl.getDtNasc());
		cliente.get(i).setSexo(cl.getSexo());
		cliente.get(i).setRg(cl.getRg());
	}
	
	public void excluirCliente(classes.Cliente cl) {
		int i = -1;
		
		for (Cliente c : cliente) {
			if (c.getIdcliente() == cl.getIdcliente())
				i = cliente.lastIndexOf(c);
		}
		
		if (i >= 0)
			this.cliente.remove(i);
	}
	
	public Livro localizarLivro(String valor, Livro.Localizar tipo) {
				
		class Localizar {
			static Livro lv = null;
			
			public static Livro titulo(ArrayList<Livro> livro, String titulo) {
				for (Livro l : livro) {
					if (l.getTitulo().equals(titulo))
						lv = l;
				}
				return lv;
			}
			
			public static Livro autor(ArrayList<Livro> livro, String autor) {
				for (Livro l : livro) {
					if (l.getAutor().equals(autor))
						lv = l;
				}
				return lv;
			}
			
			public static Livro editora(ArrayList<Livro> livro, String editora) {
				for (Livro l : livro) {
					if (l.getEditora().equals(editora))
						lv = l;
				}
				return lv;
			}
			
			public static Livro isbn(ArrayList<Livro> livro, String isbn) {
				for (Livro l : livro) {
					if (l.getIsbn().equals(isbn))
						lv = l;
				}
				return lv;
			}
		}
		
		switch(tipo) {
		case TITULO: return Localizar.titulo(livro, valor); 
		case AUTOR: return Localizar.autor(livro, valor); 
		case EDITORA: return Localizar.editora(livro, valor); 
		case ISBN: return Localizar.isbn(livro, valor); 
		default: System.out.println("Nao foi informado o tipo de pesquisa."); return null;
		}
	}
}
