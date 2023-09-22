
public class TiroAoAlvo implements Jogo{

	@Override
	public void fechar() {
		System.out.println("Salvar o progresso do jogo no servidor");
		System.out.println("Sair da partida");
		System.out.println("Sair do jogo");
	}

	@Override
	public void Jogar() {
		System.out.println("Carregando o jogo");
		System.out.println("Se conectando ao servidor");
		System.out.println("Carregando partida");
	}

}
