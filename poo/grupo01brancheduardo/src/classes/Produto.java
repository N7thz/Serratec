package classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import constantes.Util;

public class Produto {
	private int idproduto; 
	private String nome;
	private int codigo; 
	private String descricao;
	private int quantidade;
	private double valorun;
	private double valorvenda;
	private String data_hora;
	
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
	
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	
	public static Produto cadastrarProduto(){
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
		LocalDateTime data_hora_atual = LocalDateTime.now();
		Instant instant = data_hora_atual.atZone(ZoneId.systemDefault()).toInstant();
		Date sqlDate = Date.from(instant);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dataHoraFormatada = data_hora_atual.format(formatter);
		p.setData_hora(dataHoraFormatada);
        
		return p;	
	}
}
