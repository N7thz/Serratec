/*
10) 1) Crie um algoritmo que peça ao usuário que informe oito números inteiros e os armazene-os em um
vetor. Apresente o maior elemento e a posição em que ele se encontra no vetor. 

Exemplo:
0	1	2	3	4	5	6	7
4	1 	3 	7 	13  	6 	-5 	9

O maior valor do vetor informado é 13 e ele se encontra no índice 4 do vetor

*/

programa {
	funcao inicio() {
		inteiro numeros[8],maior = 0,indice = 0

		para (inteiro i = 0; i < 8; i++) {
			escreva("Digite o " + (i + 1) + " numero (inteiro): ")
			leia(numeros[i])
			se (numeros[i] > maior) {
				maior = numeros[i]
			} 
			se(numeros[i] == maior) {
				indice = i 
			}
		}
		escreva("O maior valor do vetor informado é " + maior + " e ele se encontra no índice " +  indice + " do vetor.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 394; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {indice, 15, 31, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */