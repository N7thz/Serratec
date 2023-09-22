/*
12) Faça um algoritmo que leia e mostre um vetor de 10 números inteiros. A seguir, peça ao usuário para
informar um valor inteiro e positivo e mostre todos os números do vetor que são divisíveis por esse
número. 

Exemplo:
0 	1 	2 	3 	4 	5	6 	7 	8 	9
1 	3 	5 	7 	8 	9 	10 	11 	12 	13

Valor informado: 3

Os números que são divisíveis por 3 são: 3, 9 e 12.
*/
programa {
	funcao inicio() {
		logico resposta = verdadeiro
		inteiro numeros[10],valor = 0

		para (inteiro i = 0; i < 10; i++) {
			escreva("Digite o " + (i + 1) + " numero (inteiro): ")
			leia(numeros[i])
			limpa()
		}
			
		enquanto(resposta) {
			escreva("Digite um valor: ")
			leia(valor)
			
			se (valor <= 0) {
				limpa()
				escreva("O valor digitado é invalido.")
			} senao resposta = falso
		}
		
		escreva("Os números que são divisíveis por " + valor  + " são:")

		para (inteiro i = 0; i < 10; i++) {	
			se (numeros[i] % valor == 0) 
				escreva(numeros[i] + ", ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 631; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */