package modelo;

public class Pessoa {
	private String nome;
	private String cpf;
	
	private Telefone tel_celular = new Telefone();
	private Telefone tel_residencial = new Telefone();
	private Telefone tel_trabalho = new Telefone();
	
	private Endereco end_residencial = new Endereco();
	private Endereco end_entrega = new Endereco();
	private Endereco end_cobranca = new Endereco();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Telefone getTel_celular() {
		return tel_celular;
	}
	public void setTel_celular(Telefone tel_celular) {
		this.tel_celular = tel_celular;
	}
	public Telefone getTel_residencial() {
		return tel_residencial;
	}
	public void setTel_residencial(Telefone tel_residencial) {
		this.tel_residencial = tel_residencial;
	}
	public Telefone getTel_trabalho() {
		return tel_trabalho;
	}
	public void setTel_trabalho(Telefone tel_trabalho) {
		this.tel_trabalho = tel_trabalho;
	}
	public Endereco getEnd_residencial() {
		return end_residencial;
	}
	public void setEnd_residencial(Endereco end_residencial) {
		this.end_residencial = end_residencial;
	}
	public Endereco getEnd_entrega() {
		return end_entrega;
	}
	public void setEnd_entrega(Endereco end_entrega) {
		this.end_entrega = end_entrega;
	}
	public Endereco getEnd_cobranca() {
		return end_cobranca;
	}
	public void setEnd_cobranca(Endereco end_cobranca) {
		this.end_cobranca = end_cobranca;
	}
	
	public void dadosPessoa() {
		System.out.println("""
				==============================
						DADOS DA PESSOA
				==============================
				""");
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.print("Celular: " + tel_celular.getNumero());
		System.out.println(" - Tipo: " + tel_celular.getTipo());
		System.out.println("Endereço: " + end_residencial.getLogradouro());
	}
}
