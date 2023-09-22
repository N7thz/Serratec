package Classes;

public class Empregado {
	private String nome;
	private double salario;
	private static double gastosTotais = 0;
	
	public Empregado (String nome, double salario) {
		this.setNome(nome);
		this.setSalario(salario);
		gastosTotais += salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getInfo() {
		return "Nome: " + getNome() + " | Salário: " + String.valueOf(salario);
	}
	
	protected static double getGastosTotais() {
		return gastosTotais;
	}
	
	protected static void setGastosTotais(double extra) {
		Empregado.gastosTotais += extra;
	}
}
