package Classes;

public class Relatorio {
	
	public void imprimirGastosFaculdade() {
		System.out.println("Gastos da Faculdade---------");
		System.out.println("\t" + Empregado.getGastosTotais());
	}
	
	public void imprimirInformacoes(Empregado e) {
		System.out.println("Informa��es----------");
		System.out.println("\t" + e.getInfo());
	}
}
