package heranca;

public class SubGerente extends Gerente {
	public boolean sub;

	public SubGerente(String nome, String cpf, double salario, double bonus, int senha, int numeroDeFuncionarios,
			double bonus2, boolean sub) {
		super(nome, cpf, salario, bonus, senha, numeroDeFuncionarios, bonus2);
		this.sub = sub;
	}
}
