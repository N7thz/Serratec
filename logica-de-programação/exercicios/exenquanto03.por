//Nathan felipe Ferreira

programa {
	funcao inicio() {
		cadeia usuario, senha

		escreva("Digite seu usuario: ")
		leia(usuario)
		escreva("Agora digite sua senha: ")
		leia(senha)

		enquanto(usuario != senha) {
			limpa()
	 		escreva("[ERRO]. Usuários ou Senha invalidos \n")
	 		escreva("Digite novamente seu usuario: ")
			leia(usuario)
			escreva("Agora digite novamente sua senha: ")
			leia(senha)
		}
		escreva("Acesso liberado.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 24; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */