

programa 
{


	inclua biblioteca Matematica --> m

	funcao inicio() 
	{
	
		real numero,media,calcPorcento,percentual, contador = 0.0,total = 0.0
		inteiro positivo = 0, negativo = 0
		caracter letra

		faca {
			limpa()
			escreva("Digite um numero: ")
			leia(numero)

			se (numero > 0) {
				positivo++
			} senao se (numero < 0) negativo++

			escreva("Número adicionado. \n")
			escreva("Deseja adicionar outro valor? [S/N] \n")
			leia(letra)
			
			numero = numero + total 
			total = numero
			contador++
				
		} enquanto (letra == 's' ou letra == 'S')
		limpa()
		
		percentual = negativo + positivo
		calcPorcento = positivo /percentual * 100
		calcPorcento = m.arredondar(calcPorcento,1)
		media = total / contador
		media = m.arredondar(media,2) 
			
			
		escreva("A média dos valores digitados é " + media + "\n")
		escreva("Números positivos: " + positivo + "\n")
		escreva("Números negativos: " + negativo + "\n")
		escreva("Desses números " + calcPorcento + "% são positivos e " + (100 - calcPorcento) + "% são negativos.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 488; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */