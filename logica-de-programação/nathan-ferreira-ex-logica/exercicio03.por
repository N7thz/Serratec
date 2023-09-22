/*
3) Faça um programa que leia três valores (A, B, C)
e mostre-os na ordem lida.  Em seguida, 
mostre-os em ordem crescente e decrescente.
*/

programa {
	funcao inicio() {
		inteiro numero[3],crescente[3]	
		inteiro maior = 0 ,menor = 0
		

		para (inteiro i = 0; i < 3; i++) {
			escreva("Digite o ",(i+1), " numero: ")
			leia(numero[i])
		}
		
		para(inteiro i = 0; i < 3; i++) {
			escreva(numero[i] + "\t")
		}

		para(inteiro i = 0; i < 3; i++) {
			se (numero[0] > numero[1] e numero[0] > numero[2] e numero[1] > numero[2] ) {
				crescente[2] = numero[0]
				crescente[1] = numero[1]
				crescente[0] = numero[2]
			} senao se (numero[0] > numero[1] e numero[0] > numero[2] e numero[1] < numero[2] ) {
				crescente[2] = numero[0]
				crescente[1] = numero[2]
				crescente[0] = numero[1]
			} senao se (numero[1] > numero[0] e numero[1] > numero[2] e numero[0] > numero[2]) {
				crescente[2] = numero[1]
				crescente[1] = numero[0]
				crescente[0] = numero[2]
			} senao se (numero[1] > numero[0] e numero[1] > numero[2] e numero[0] < numero[2]) {
				crescente[2] = numero[1]
				crescente[1] = numero[2]
				crescente[0] = numero[0]
			}senao se (numero[2] > numero[0] e numero[2] > numero[1] e numero[1] > numero[0]) {
				crescente[2] = numero[2]
				crescente[1] = numero[1]
				crescente[0] = numero[0]
			}senao se (numero[2] > numero[0] e numero[2] > numero[1] e numero[1] < numero[0]) {
				crescente[2] = numero[2]
				crescente[1] = numero[0]
				crescente[0] = numero[1]
			}
			escreva(crescente[i])
		} 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1526; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */