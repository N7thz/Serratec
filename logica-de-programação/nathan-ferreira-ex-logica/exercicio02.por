/*
2) Faça um programa que verifique e mostre os números 
entre 1.000 e 2.000 (inclusive) que, quando divididos 
por 11 produzam resto igual a 2.
*/

programa {
	funcao inicio() {
		inteiro contador = 0
		para (inteiro i = 1000; i < 2000; i++) {
			se (i % 11 == 2) {
				escreva(i + "\n")
				contador++
			}
		}
		escreva("Ao total "+ contador + " números são aceitaveis.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */