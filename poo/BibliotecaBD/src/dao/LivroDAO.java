package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import classes.Livro;
import conexao.Conexao;

public class LivroDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pInclusao;
	PreparedStatement pAlteracao;
	
	public LivroDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
		prepararSqlAlteracao();
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".livro";	
		sql += " (titulo, autor, editora, isbn, nrpaginas, quantidade)";
		sql += " values ";
		sql += " (?, ?, ?, ?, ?, ?)";
		
		try {
			this.pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlAlteracao() {
		String sql = "update "+ this.schema + ".livro";	
		sql += " set titulo = ?,";
		sql += " autor = ?,";
		sql += " editora = ?,";
		sql += " isbn = ?,";
		sql += " nrpaginas = ?,";
		sql += " quantidade = ?";
		sql += " where idlivro = ?";
		
		try {
			this.pAlteracao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public int alterarCliente(Livro livro) {
		try {
			pAlteracao.setString(1, livro.getTitulo());
			pAlteracao.setString(2, livro.getAutor());
			pAlteracao.setString(3, livro.getEditora());
			pAlteracao.setString(4, livro.getIsbn());
			pAlteracao.setInt(5, livro.getNumPaginas());
			pAlteracao.setInt(6, livro.getQuantidade());
			pAlteracao.setInt(7, livro.getIdlivro());
			
			return pAlteracao.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nLivro nao alterado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	public int incluirCliente(Livro livro) {
		try {		
							
			pInclusao.setString(1, livro.getTitulo());
			pInclusao.setString(2, livro.getAutor());
			pInclusao.setString(3, livro.getEditora());
			pInclusao.setString(4, livro.getIsbn());
			pInclusao.setInt(5, livro.getNumPaginas());
			pInclusao.setInt(6, livro.getQuantidade());
			
			return pInclusao.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nLivro nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	@SuppressWarnings("exports")
	public ResultSet carregarLivros() {
		ResultSet tabela;				
		String sql = "select * from " + this.schema + ".livro order by idlivro";
		
		tabela = conexao.query(sql);
		
		return tabela;
	}
}
