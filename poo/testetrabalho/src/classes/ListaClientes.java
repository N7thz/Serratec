package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexao.Conexao;
import dao.ClienteDAO;

public class ListaClientes {
	private Conexao con;
	private String schema;
	
	ArrayList<Cliente> cliente = new ArrayList<>();
	
	
	public ListaClientes (Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
		
		carregarListaClientes();
	}
	public void adicionarClienteLista(Cliente c) {
		this.cliente.add(c);
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
	
	private Cliente dadosCliente(ResultSet tabela) { 
		Cliente c = new Cliente();
int codigo;
		
		try {
			codigo = tabela.getInt("codigo");
			if(codigo != 0)
				c.setCodigo(codigo);
			c.setIdcliente(tabela.getInt("idcliente"));
			c.setNome(tabela.getString("nome"));
			c.setCpf_cnpj(tabela.getString("cpf_cnpj"));			
			c.setEndereco(tabela.getString("endereco"));
			c.setTelefone(tabela.getString("telefone"));
			c.setTelefone(tabela.getString("email"));
			c.setData_hora(tabela.getString("data_hora"));

			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

