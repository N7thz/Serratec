package Empregados;

public class Professor extends Empregados {
	private  double horaDeAula;

	public Professor(String nome, double salario, double horaDeAula) {
		super(nome, salario);
		this.horaDeAula = horaDeAula;
	}

	public double getHoraDeAula() {
		return horaDeAula;
	}

	public void setHoraDeAula(double horaDeAula) {
		this.horaDeAula = horaDeAula;
	}
	
	public double horaPag(double h) {
		return h*10;
	}

	public double getGastos(Professor p,double h) {
		return p.getSalario() + horaPag(h);
	}
}




