/*
5) Escreva um programa que lê o tamanho do lado de um quadrado e imprime um quadrado daquele tamanho com asteriscos. 
Seu programa deve usar laços de repetição e funcionar para quadrados com lados de todos os tamanhos entre 1 e 20.

Por exemplo, para lado igual a 5:

 *****
 *****
 *****
 *****
 *****

*/
programa {
	
	inclua biblioteca Tipos --> tip

	funcao inicio() {
		inteiro nQuadrado
		caracter symbol
		

		escreva("Digite o numero de '*' que o quadrado deve ter (de 1 a 20):")
		leia(nQuadrado)
		escreva("Digite o simbolo q desejar: ")
		leia(symbol)


		se (nQuadrado < 1 ou nQuadrado > 20) {
			escreva("valor inválido.")
		} senao {
			para (inteiro i = 0; i < nQuadrado; i++) {
				escreva("\n")
				para (inteiro j = 0; j < nQuadrado; j++) {	
					escreva(symbol)					
				}
			}
		}
		escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 819; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */