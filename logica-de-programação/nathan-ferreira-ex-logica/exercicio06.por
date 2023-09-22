/*
6) Escreva um programa que lê o tamanho do lado de um quadrado e imprime um 
quadrado daquele tamanho com asteriscos e espaços em branco. 
Seu programa deve funcionar para quadrados com lados de todos os tamanhos entre 1 e 20.
Para lado igual a 5:
*****
*   *
*   *
*   *
*****
*/
programa {
	funcao inicio() {
		inteiro numero

		escreva("Digite o lado do quadrado: ")
		leia(numero)

		para (inteiro i = 0; i < numero; i++) {
			se (i == 0 ou i == (numero-1)) {
				para (inteiro j = 0; j < numero; j++) {
					escreva(" * ")
				}
			escreva("\n")	
			} senao {
				para (inteiro k = 0; k < numero; k++) {
					se (k == 0 ) {
						escreva(" * ")
					} senao se (k == (numero - 1)) {
						escreva(" * \n")
					} senao {
						escreva("   ")
					}
				}
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 751; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numero, 14, 10, 6}-{i, 19, 16, 1}-{j, 21, 18, 1}-{k, 26, 18, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */