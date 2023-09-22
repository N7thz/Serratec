package Classes;

public class Coordenador extends Empregado {
	private double bonus;
	
	public Coordenador(String nome, double salario, double bonus) {
		super(nome, salario + bonus);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
