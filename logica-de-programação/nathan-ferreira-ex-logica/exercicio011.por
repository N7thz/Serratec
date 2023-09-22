/*
11) Crie um algoritmo que peça ao usuário que informe 10 números inteiros, armazene-os em um vetor
e apresente a soma de todos os valores. 

Exemplo:
0 	1 	2 	3 	4 	5 	6 	7 	8 	9
1 	3 	5 	7 	8 	9 	10 	11 	12 	13

A soma de todos os valores do vetor é: 79. 
*/

programa {
	funcao inicio() {
		inteiro numeros[10],total = 0

		para (inteiro i = 0; i < 10; i++) {
			escreva("Digite o " + (i + 1) + " numero (inteiro): ")
			leia(numeros[i])
			total = total + numeros[i]
			limpa()
		}
		escreva("A soma de todos os valores do vetor é: " + total + ".")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 480; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */