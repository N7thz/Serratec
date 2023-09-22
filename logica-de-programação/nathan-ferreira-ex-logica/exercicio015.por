/*
15) Escreva um algoritmo que solicite ao usuário a entrada de 5 números,
e que exiba o somatório desses números na tela.
Após exibir a soma, o programa deve mostrar também os
números que o usuário digitou, um por linha.
*/
programa {
	funcao inicio() {
		inteiro numeros[5],total = 0
	
		para (inteiro i = 0; i < 5; i++) {
			escreva("Digite o " + (i + 1) + " numero (inteiro): ")
			leia(numeros[i])
			limpa()
		}
		
		para (inteiro i = 0; i < 5; i++) {
			total += numeros[i] 
		}

		escreva("O somatório dos valores é " + total + ".\n\n")

		para (inteiro i = 0; i < 5; i++) {
			escreva(numeros[i],"\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 543; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */