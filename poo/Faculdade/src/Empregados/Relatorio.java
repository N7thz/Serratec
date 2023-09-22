package Empregados;

public class Relatorio {

	public static void getInfo(Empregados p) {
		exibirCabecalho("FUNCIONARIO");
		System.out.print("Nome do funcionario: ");
		System.out.println(p.getNome());
		System.out.print("Salário do funcionario:");
		System.out.println(" R$" +  p.getSalario());
	}
	
	public static void getInfoProf(Professor p) {
		exibirCabecalho("PROFESSOR");
		System.out.print("Nome do funcionario: ");
		System.out.println(p.getNome());
		System.out.print("Salário do funcionario:");
		System.out.println(" R$" +  p.getSalario());
		System.out.print("Horas trabalhadas: ");
		System.out.println(p.getHoraDeAula());
		System.out.print("Total: ");
		System.out.println(p.getGastos((p), p.getHoraDeAula()));
	}
	
	public static void exibirCabecalho(String obj) {
		System.out.println("============================================");
		System.out.println("		" + obj);
		System.out.println("============================================");
	}
}
