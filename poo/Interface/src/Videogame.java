
public class Videogame {
	private boolean estaLigado;
	private Jogo jogo; // null
	
	
	public void ligar() {
		System.out.println("Ligando o videogame...");
		this.estaLigado = true;
	}
	
	public void jogar(Jogo jogo) {
		if (estaLigado == true ) {
			System.out.println("Iniciando o jogo...");
			this.jogo = jogo;
			jogo.Jogar();
		}
		
	}
	
	public void fechar() {
		System.out.println("Fechando o jogo...");
		boolean temJogoRodando = jogo != null;
		if (temJogoRodando) {
			jogo.fechar();
			jogo = null; //
		} else {
			System.out.println("Não tem nenhum jogo rodando!");
		}
	}
}
