/*
14) Crie um algoritmo que peça ao usuário que informe 10 números inteiros e armazene-os em um vetor.
A seguir, apresente a multiplicação de todos os elementos pares e a soma de todos os elementos
ímpares. 

Exemplo:
0 	1 	2 	3 	4 	5 	6 	7 	8 	9
1 	3 	5 	7 	8 	9 	10 	11 	12 	13

Multiplicação dos elementos pares: 960.
Soma dos elementos ímpares: 49
*/
programa {
	funcao inicio() {
		inteiro numeros[10],totalPar = 1,totalImpar = 0
		
		para (inteiro i = 0; i < 10; i++) {
			escreva("Digite o " + (i + 1) + " numero (inteiro): ")
			leia(numeros[i])
			limpa()
		}

		para (inteiro i = 0; i < 10; i++) {
			se (numeros[i] % 2 == 0) {
				totalPar *= numeros[i]				
			} senao {
				totalImpar += numeros[i]
			}
		}
		escreva("Multiplicação dos elementos pares: " + totalPar + ".\n")
		escreva("Soma dos elementos ímpares: " + totalImpar + ".\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 851; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */