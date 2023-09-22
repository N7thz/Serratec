//Nathan felipe Ferreira

programa {
	funcao inicio() {
	 	real numero

	 	escreva("Digite um numero entre 0 e 10: ")
	 	leia(numero)

	 	enquanto(numero < 0 ou numero > 10) {
	 		limpa()
	 		escreva("[ERRO]. o numero digitado não é valido \n")
	 		escreva("Digite outro numero: ")
	 		leia(numero)
	 	}
		escreva("O número digitado é válido")	 	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */