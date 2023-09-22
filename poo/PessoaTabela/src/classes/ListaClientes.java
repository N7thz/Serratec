package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
