package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import classes.Pedido;
import classes.Produto;
import conexao.Conexao;

public class PedidoDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pInclusao;
	PreparedStatement pAlteracao;
	PreparedStatement pExclusao;
	PreparedStatement pInclusaoItens;
	
	public PedidoDAO(Conexao conexao, String schema) {
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
        prepararSqlAlteracao();
        prepararSqlExclusao();
        prepararSqlInclusaoItens();
	}
	
	private void prepararSqlInclusaoItens() {
		String sql = "insert into "+ this.schema + ".pedido_itens";	
		sql += " (id_pedido, id_produto, quantidade, valor_venda)";
		sql += " values ";
		sql += " (?, ?, ?, ?)";
		
		try {
			this.pInclusaoItens =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	private void prepararSqlExclusao() {
		String sql = "delete from "+ this.schema + ".pedido";
		sql += " where id_pedido = ?";
		
		try {
			this.pExclusao = conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".pedido";	
		sql += " (codigo, id_cliente, total_pedido, data_hora)";
		sql += " values ";
		sql += " (?, ?, ?, ?)";
		
		try {
			this.pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private void prepararSqlAlteracao() {
		String sql = "update "+ this.schema + ".pedido";	
		sql += " set ";
		sql += " codigo = ?,";
		sql += " id_cliente = ?,";
		sql += " total_pedido = ?,";
		sql += " data_hora = ?";
		sql += " where id_pedido = ?";
		
		try {
			this.pAlteracao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public int alterarPedido(Pedido pedido) {
		try {
			pAlteracao.setInt(1, pedido.getCodigo());
			pAlteracao.setInt(2,  pedido.getCliente().getIdcliente());
			pAlteracao.setDouble(3, pedido.getTotal_pedido());
			pAlteracao.setString(4, pedido.getData_hora());
			
			return pAlteracao.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nProduto nao alterado.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}

	public void incluirItens(Pedido pedido) {
		try {		
			for (int i = 0; i < pedido.getItens().size()-1; i++) {
				pInclusao.setInt(1, pedido.getId_pedido());
				pInclusao.setInt(2, pedido.getItens().get(i).getIdproduto() );
				pInclusao.setInt(3, pedido.getItens().get(i).getQuantidade());
				pInclusao.setDouble(4, pedido.getItens().get(i).getValorvenda());
				pInclusao.executeUpdate();
			}
		} catch (Exception e) {
			
		}
	}
	
	public int incluirPedido(Pedido pedido) {
		try {					
			pInclusao.setInt(1, pedido.getCodigo());
			pInclusao.setInt(2,  pedido.getCliente().getIdcliente());
			pInclusao.setDouble(3, pedido.getTotal_pedido());
			pInclusao.setString(4, pedido.getData_hora());
			pInclusao.executeUpdate();
			
			String sql = "select id_pedido from " + this.schema + ".pedido order by id_pedido desc limit 1"; 
			
			ResultSet tabela = conexao.query(sql);
			try {
				if (tabela.next()) {
					pedido.setId_pedido(tabela.getInt("id_pedido"));
					incluirItens(pedido);
					return tabela.getInt("id_pedido");
				} else {
					return 0;
				}
			} catch (Exception e) {
				return 0;
			}
			
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedido nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	public int excluirPedido(Pedido pedido) {
		try {
			pExclusao.setInt(1, pedido.getId_pedido());
			
			return pExclusao.executeUpdate();
		} catch  (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedido nao excluido.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	@SuppressWarnings("exports")
	public ResultSet carregarPedido() {
		ResultSet tabela;				
		String sql = "select * from " + this.schema + ".pedido order by id_pedido ";
		
		tabela = conexao.query(sql);
			
		return tabela;
	}
}
