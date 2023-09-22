package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import constantes.Util;


public class Pedido {
	private int id_pedido;
	private int codigo;
	private Cliente cliente;
	private double total_pedido;
	private String data_hora;
	private ArrayList<Item> itens = new ArrayList<>();
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	public double getTotal_pedido() {
		return total_pedido;
	}
	public void setTotal_pedido(double total_pedido) {
		this.total_pedido = total_pedido;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	public static Pedido cadastrarPedido(){
		Pedido p = new Pedido();
		Scanner in = new Scanner(System.in);
		
		String r;
		
		System.out.println(Util.LINHA);
		System.out.println("Cadastro de Pedidos: ");
		System.out.println(Util.LINHA);
		
		//incluirProdutoPedido(p);

			
		LocalDateTime data_hora_atual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dataHoraFormatada = data_hora_atual.format(formatter);
		p.setData_hora(dataHoraFormatada);
        
		return p;	
	}
	
	
	
	public static int localizarPedido() {
		System.out.println("Localizando pedido");
		return Util.validarInteiro("Informe o codigo do pedido: ");
	}	

}