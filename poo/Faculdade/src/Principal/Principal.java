package Principal;

import Classes.*;

public class Principal {

	public static void main(String[] args) {
		Empregado e1 = new Empregado("João", 1500);
		Empregado e2 = new Empregado("Alan", 1500);
		Professor p1 = new Professor("Leleco", 1600, 5);
		Coordenador c1 = new Coordenador("Meire", 2000, 200);
		Relatorio rel = new Relatorio();
		
		rel.imprimirGastosFaculdade();
		rel.imprimirInformacoes(e1);
		rel.imprimirInformacoes(e2);
		rel.imprimirInformacoes(p1);
		rel.imprimirInformacoes(c1);
	}
}
