package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexao.Conexao;
import dao.ProdutoDAO;
import dao.PedidoDAO;



public class ListaItens {
	private Conexao con;
	private String schema;	
	
	ArrayList<Item> itens = new ArrayList<>();
	
	public ListaItens (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		carregarListaItens();
	}
	
	public void adicionaItens(Item i) {
		this.itens.add(i);
	}
	
	private void carregarListaItens() {
		ProdutoDAO pdao = new ProdutoDAO(con, schema);
		
		ResultSet tabela = pdao.carregarProduto();
		this.itens.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.itens.add(dadosItens(tabela));				
			}
			
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Item dadosItens(ResultSet tabela) { 
		Item p = new Item();
		int codigo;
		
		try {
			codigo = tabela.getInt("codigo");
			if(codigo != 0)
				p.setCodigo(codigo);
			p.setIdproduto(tabela.getInt("id_produto"));
			p.setQuantidade(tabela.getInt("quantidade"));		
			p.setValorvenda(tabela.getFloat("valor_venda"));
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void excluirItem(Item i) {
		itens.removeIf(pd -> pd.getIdproduto() == i.getIdproduto());
	}
}

	
