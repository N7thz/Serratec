package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexao.Conexao;
import dao.PedidoDAO;

public class ListaPedidos {
	private Conexao con;
	private String schema;
	
	ArrayList<Pedido> pedido = new ArrayList<>();
	
	public ListaPedidos(Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		carregarListaPedido();
	}
	
	public void adicionarPedidoLista(Pedido p) {
		this.pedido.add(p);
	}
	
	public Pedido localizarPedido(int idPedido) {
		Pedido localizado = null;
		
		for(Pedido p : pedido) {
			if(p.getId_pedido() == idPedido) {
				localizado = p;
				break;
			}
		}
		return localizado;
	}
	
	private void carregarListaPedido() {
		PedidoDAO pdao = new PedidoDAO(con,schema);
		
		ResultSet tabela = pdao.carregarPedido();
		this.pedido.clear();
		
		try {
			tabela.beforeFirst();
			
			while (tabela.next()) {							
				this.pedido.add(dadosPedido(tabela));				
			}
			
			tabela.close();
		
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	private Pedido dadosPedido(ResultSet tabela) {
		Pedido p = new Pedido();
		ListaClientes lc = new ListaClientes(con , schema);
		int codigo;
		
		try {
			codigo = tabela.getInt("codigo");
			if(codigo != 0)
				p.setCodigo(codigo);
			p.setId_pedido(tabela.getInt("idpedido"));
			p.setCliente(lc.localizarCliente(tabela.getInt("idcliente")));
			p.setData_hora(tabela.getString("data_hora"));
			return (Pedido) p ;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void imprimirPedidos() {
		System.out.println("Lista de Pedidos");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("ID:\t\t id-pedido: \t\t Código:\t\tid-cliente:\t\tid-produto:\t\t\total Pedido:\t\t\\n");
		System.out.println("--------------------------------------------------------------------");
		
		for(Pedido p : pedido) {
			System.out.println(	p.getId_pedido()+ "\t\t" + p.getCodigo() + "\t\t" + p.getCliente().getIdcliente() + "\t\t" + p.getTotal_pedido() + "\t\t" + p.getData_hora());
		}
	}
	
	
}

