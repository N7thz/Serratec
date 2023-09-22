/*
	8) Faça um programa que peça um número inteiro e determine se ele é ou não um número primo.
	Um número primo é aquele que é divisível somente por ele mesmo e por 1.
*/

programa {
	funcao inicio() {
		inteiro numero,contador = 0

		escreva("Digite um numero: ")
		leia(numero)

		para (inteiro i = numero; i > 0; i--) {
			se (numero%i == 0) {
				contador++
			}
		}
		
		se (contador > 2) {
			escreva("O numero nao é primo")
		} senao escreva("O numero é primo")
	} 
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 367; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */