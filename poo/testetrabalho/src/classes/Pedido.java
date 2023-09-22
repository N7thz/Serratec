package classes;

import java.time.LocalDateTime;

public class Pedido {
	private int id_pedido;
	private int id_cliente;
	private double total_pedido;
	private LocalDateTime data_hora;
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public double getTotal_pedido() {
		return total_pedido;
	}
	public void setTotal_pedido(double total_pedido) {
		this.total_pedido = total_pedido;
	}
	public LocalDateTime getData_hora() {
		return data_hora;
	}
	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}

}
