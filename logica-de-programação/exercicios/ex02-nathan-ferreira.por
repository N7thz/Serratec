/*
 Nathan Felipe Ferreira 
	
2) Escrever um algoritmo que leia uma quantidade desconhecida de números e conte quantos deles 
estão nos seguintes intervalos: [0-25], [26-50], [51-75] e [76-100]. A entrada de dados deve terminar 
quando for lido um número negativo.
*/

programa {
	funcao inicio() {
		real numero 
		inteiro case01 = 0, case02 = 0, case03 = 0, case04 = 0
		caracter letra
		
		faca {
			limpa()
			escreva("Digite um numero: ")
			leia(numero)

			se (numero >= 0 e numero <= 25) {
				case01++
			} senao se (numero <= 50) {
				case02++
			} senao se (numero <= 75) {
				case03++
			} senao se (numero < 100) {
				case04++
			}
						
			se (numero < 0 ) {
				escreva("Número negativo") 
				pare
			} senao {
				escreva("Número adicionado. \n")
				escreva("Deseja adicionar outro valor? [S/N] \n")
				leia(letra)
			}
		} enquanto (letra == 's' ou letra == 'S')		
		escreva("Numeros entre [0-25]: " + case01 + "\n")
		escreva("Numeros entre [26-50]: " + case02 + "\n")
		escreva("Numeros entre [51-75]: " + case03 + "\n")
		escreva("Numeros entre [76-100]: " + case04 + "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */