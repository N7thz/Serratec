
public class Circulo implements FiguraGeometrica {
	private int raio; 
	
	public Circulo(int raio) {
		this.raio = raio;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	@Override
	public double calcularArea() {
		double area = Math.PI * Math.pow(raio, 2);
		return area;
	}
}
