package dao;

import java.sql.PreparedStatement;

import classes.Funcionarios;
import conexao.Conexao;

public class FuncionarioDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pInclusao;
	
	public FuncionarioDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".funcionario";	
		sql += " (nome, cpf, endereco, rg, cargo, ctps, salario)";
		sql += " values ";
		sql += " (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public int incluir(Funcionarios funcionario) {
		try {
			pInclusao.setString(1, funcionario.getNome());
			pInclusao.setString(2, funcionario.getCpf());
			pInclusao.setString(3, funcionario.getEndereco());
			pInclusao.setString(4, funcionario.getRg());
			pInclusao.setString(5, funcionario.getCargo());
			pInclusao.setString(6, funcionario.getCtps());
			pInclusao.setDouble(7, funcionario.getSalario());

			int retorno = pInclusao.executeUpdate(); 
			
			return retorno;
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nFuncionario nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}
}
