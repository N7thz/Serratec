public class teste {
    package classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
//import java.util.Date;
import java.util.Scanner;
import java.sql.Date;


import constantes.Util;

public class Produto {
	private int idproduto; 
	private String nome;
	private int codigo; 
	private String descricao;
	private int quantidade;
	private double valorun;
	private double valorvenda;
	private Date data_hora;
	
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorun() {
		return valorun;
	}
	public void setValorun(double valorun) {
		this.valorun = valorun;
	}
	public double getValorvenda() {
		return valorvenda;
	}
	public void setValorvenda(double valorvenda) {
		this.valorvenda = valorvenda;
	}
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	
	
	public static Produto cadastrarProduto() {
		Produto p = new Produto();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println(Util.LINHA);
		System.out.println("Cadastro de produto: ");
		System.out.println(Util.LINHA);
		
		Util.br();
		
		System.out.println("Informe o nome do produto: ");
		String s = in.nextLine();
		p.setNome(s);
	
		System.out.println("Informe o codigo do produto: ");
		int i = in.nextInt(); 
		p.setCodigo(i);
		
		System.out.println("Informe a descrição do produto: ");
		s = in.nextLine();
		s = in.nextLine();
		p.setDescricao(s);
		
		System.out.println("Informe a quantidade: ");
		i = in.nextInt();
		p.setQuantidade(i);
		
		System.out.println("Informe o valor unitario: ");
		double d = in.nextDouble();
		p.setValorun(d);
		double margem;
		margem = d*0.4;
		d += margem;
		p.setValorvenda(d);
		//System.out.println("Valor de venda: "+d);
		LocalDateTime data_hora_atual = LocalDateTime.now();
		Instant instant = data_hora_atual.atZone(ZoneId.systemDefault()).toInstant();
		Date sqlDate = (Date) Date.from(instant);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		//String dataHoraFormatada = data_hora_atual.format(formatter);
		
		//System.out.println(data_hora_atual);
		//System.out.println(sqlDate);
		
		// Crie um objeto java.util.Date com a data atual
        java.util.Date utilDate2 = Calendar.getInstance().getTime();

        // Converta o java.util.Date em java.sql.Date
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
        p.setData_hora(sqlDate2);
        
		return p;
		
		
	}
	
	
	

	public static Produto cadastrarProduto() {
	    Produto p = new Produto();
	    Scanner in = new Scanner(System.in);

	    System.out.println(Util.LINHA);
	    System.out.println("Cadastro de produto: ");
	    System.out.println(Util.LINHA);

	    Util.br();

	    System.out.println("Informe o nome do produto: ");
	    String nome = in.nextLine();
	    p.setNome(nome);

	    System.out.println("Informe o codigo do produto: ");
	    int codigo = in.nextInt();
	    p.setCodigo(codigo);

	    // Limpar o buffer após a leitura do número inteiro
	    in.nextLine();

	    System.out.println("Informe a descrição do produto: ");
	    String descricao = in.nextLine();
	    p.setDescricao(descricao);

	    System.out.println("Informe a quantidade: ");
	    int quantidade = in.nextInt();
	    p.setQuantidade(quantidade);

	    System.out.println("Informe o valor unitario: ");
	    double valorUnitario = in.nextDouble();
	    p.setValorun(valorUnitario);

	    // Calcular o valor de venda com 40% de margem
	    double margem = valorUnitario * 0.4;
	    double valorVenda = valorUnitario + margem;
	    p.setValorvenda(valorVenda);

	    // Obter a data e hora atual em java.sql.Date
	    java.util.Date utilDate = Calendar.getInstance().getTime();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    p.setData_hora(sqlDate);

	    return p;
	}
}

}
