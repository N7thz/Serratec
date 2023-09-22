
public class Principal {
	public static void main(String[] args) {
		
		Fracoes fracao01 = new Fracoes(2,7);
		Fracoes fracao02 = new Fracoes(4,7);
		
		cadastraFracoes(fracao01,fracao02);
	}
	
	public static void cadastraFracoes(Fracoes numerador,Fracoes denominador) {
		
		if (numerador.getDenominador() == denominador.getDenominador()) {
			int resultNum = numerador.getNumerador() + denominador.getNumerador();
			System.out.println("  " + resultNum);
			System.out.println("----- ");
			System.out.println("  " + numerador.getNumerador());
		} else {
			
		}
	}
	
	public static int MMC(Fracoes fracao01,Fracoes fracao02) {
		boolean saida = true;
		int resultMMC = 0;
		
		while (saida) {
			int indice = 2;
			if (fracao01.getDenominador() / indice == 1 && fracao01.getDenominador() / indice == 0) {
				resultMMC = indice;
			} else {
				indice++;
				saida = false;
			}
		}
		
		return resultMMC;
		
	}
}
