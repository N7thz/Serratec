
public class Quadrado implements FiguraGeometrica {
	private int lado;
	
	public Quadrado(int lado) {
		super();
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	
	@Override
	public double calcularArea() {
		return Math.pow(lado, 2);
	}
	
	
}
