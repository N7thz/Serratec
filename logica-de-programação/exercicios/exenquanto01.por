//Nathan felipe Ferreira

programa {
	funcao inicio() {
		inteiro numero, contador = 0

		escreva("Digite um numero: ")
		leia(numero)

		enquanto(contador != numero) {
			contador++
		}
		escreva("Entre " + numero + " e " + "1, Existem " + (contador - 1) + " números")
	}
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 272; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {contador, 5, 18, 8}-{numero, 5, 10, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */