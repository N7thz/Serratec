package classes;

public class SubGerente extends Gerente {
	public boolean sub;
	
	public SubGerente(String nome, String cpf, double salario, double bonus) {
		super(nome, cpf, salario, bonus);
	}
}
