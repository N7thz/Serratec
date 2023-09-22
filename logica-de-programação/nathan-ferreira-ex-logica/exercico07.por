/*
7) Faça um programa que recebe a altura de um triangulo em um número inteiro e imprima-o utilizando asteriscos. Veja o Exemplo:

Entrada: 5

*
**
***
****
*****
*/
programa {
	funcao inicio() {
		/*inteiro altura

		escreva("Digite a alturta do triangulo: ")
		leia(altura)

		para (inteiro i = 0; i < altura; i++) {
			escreva("\n")
			para (inteiro j = altura; j > 0; j--) {
				escreva(" * ")		
			}
		}*/

		inteiro altura
		inteiro i=0, j=0

		escreva("Digite a alturta do triangulo: ")
		leia(altura)

		para(i = 1; i<=altura; i++){
			escreva("\n")
			para(j=1; j<=i; j++) {
				escreva(" * ")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 544; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */