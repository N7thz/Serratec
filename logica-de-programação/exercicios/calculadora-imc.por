programa {
	funcao inicio() {
		
		real peso,altura,imc,altQuadrada

		escreva("Olá! \n Digite seu peso(Kg): ")
		leia(peso)
		escreva("\n ok. Agora digite sua altura(M): ") 
		leia(altura)

		altQuadrada = altura * altura
		imc = peso / altQuadrada
		
		escreva("Seu imc é " + imc + ".\n")

		se (imc <= 18.5) {
			escreva("Você está abaixo do peso. :(")
		} senao se (imc <= 24.9) {
			escreva("Você está com um peso saudável. :)")
		} senao se (imc <= 29.9) {
			escreva("Você está com um sobrepeso. :/")
		} senao {
			escreva("Você está obeso. :(")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 454; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */