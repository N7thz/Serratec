
public class Balanco {
	

	private double janeiro = 0;
	private double fevereiro = 0;
	private double marco = 0;
	private double abril = 0;
	private double maio = 0;
	private double junho = 0;
	
	public Balanco(double janeiro, double fevereiro, double marco) {
		this.janeiro = janeiro;
		this.fevereiro = fevereiro;
		this.marco = marco;
		
		System.out.println("Atribuído o trimestre.");
	}
	
	public Balanco(double janeiro, double fevereiro, double marco,
			double abril, double maio, double junho) {
		
		this(janeiro, fevereiro, marco);
		
		this.abril = abril;
		this.maio = maio;
		this.junho = junho;
		
		System.out.println("Atribuído o semestre.");
	} 
	
	public double getJaneiro() {
		return janeiro;
	}

	public double getFevereiro() {
		return fevereiro;
	}

	public double getMarco() {
		return marco;
	}

	public double getAbril() {
		return abril;
	}

	public double getMaio() {
		return maio;
	}

	public double getJunho() {
		return junho;
	}
}
