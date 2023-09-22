/*
 Nathan Felipe Ferreira 
	
3) Fatorial: Escreva um algoritmo que leia um valor inicial A e imprima a seqüência de valores do cálculo 
de A! e o seu resultado.Ex: 5! = 5 X 4 X 3 X 2 X 1 = 120
*/

programa {
	funcao inicio() {
		inteiro numero,contador,fatorial = 0

		escreva("Digite um numero: ")
		leia(numero)

		contador = numero - 1

		escreva(numero + "! = " )
		
		enquanto (contador >= 0) {					
			se (contador >= 1){
				escreva(contador + 1 + " X ")		
			} senao se (contador == 0) {
				escreva(contador + 1)
				pare	
			} 
			fatorial = numero
			fatorial = fatorial * contador
			numero = fatorial
			contador--
		}
		escreva(" = " + fatorial)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 535; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */