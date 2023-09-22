package Classes;

public class Professor extends Empregado {
	private int horasAulas;
	
	public Professor(String nome, double salario, int horasAula) {		
		super(nome, salario + (horasAula *10));
		this.horasAulas = horasAula;
		
		//setGastosTotais(horasAula * 10);
	}

	public int getHorasAulas() {
		return horasAulas;
	}

	public void setHorasAulas(int horasAulas) {
		this.horasAulas = horasAulas;
	}
	
	public String getInfo() {
		return "Nome: " + getNome() + " | Salário: " + String.valueOf(getSalario()) + " | " + getHorasAulas();
	}
	
}
