package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexao.Conexao;
import dao.ProdutoDAO;

public class ListasProdutos {
	private Conexao con;
	private String schema;
	
	ArrayList<Produto> produto = new ArrayList<>();
	
	public ListasProdutos(Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
	}
	
	public void adicionarProdutoLista(Produto p) {
		this.produto.add(p);
	}
	
	private void carregarListaProduto() {
		ProdutoDAO pdao = new ProdutoDAO(con,schema);
		
		ResultSet tabela = pdao.carregarProduto();
		this.produto.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.produto.add(dadosProduto(tabela));				
			}
			
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Produto dadosProduto(ResultSet tabela) {
		Produto p = new Produto();
		int codigo;
		
		try {
			codigo = tabela.getInt("codigo");
			if(codigo != 0)
				p.setCodigo(codigo);
			p.setIdproduto(tabela.getInt("idproduto"));
			p.setNome(tabela.getString("nome"));
			p.setDescricao(tabela.getString("descricao"));
			p.setQuantidade(tabela.getInt("quantidade"));
			p.setValorun(tabela.getFloat("valorUni"));
			p.setValorvenda(tabela.getFloat("valorDeVenda"));
			p.setData_hora(tabela.getString("dataHora"));
			return (Produto) p ;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
