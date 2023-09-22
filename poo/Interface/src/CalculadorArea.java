
public class CalculadorArea {
	public double somarAreas(FiguraGeometrica figura01, FiguraGeometrica figura02) {
		double totalArea = figura01.calcularArea()  + figura02.calcularArea();
		return totalArea;
	}
}
