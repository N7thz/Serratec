/*
4) Uma loja tem tem uma política de descontos de acordo
com o valor da compra do cliente. Os descontos começam
acima dos R$500. A cada 100 reais acima dos R$500,00 o 
cliente ganha 1% de desconto cumulativo até 25%. 
Por exemplo: R$500 = 1% || R$600,00 = 2% … etc…

Faça um programa que exiba essa tabela de descontos no
seguinte formato:  

Valordacompra – porcentagem de desconto – valor final

O total da compra deverá ser armazenado num vetor e a 
apresentação das compras realizadas e seus descontos, 
deve ser a partir desse vetor.
*/
programa {
	funcao inicio() {
		
		inteiro desconto[5] 
		real totalCompras,valorDesconto,totalCompra = 0
		real valorFinal[5]
		caracter resposta = 's'
		
		real compras[5],descontoVetor[5]

		para(inteiro i = 0; i < 5; i++) {
			escreva("Digite o valor da compra:  \n")
			leia(compras[i])
			
			se (compras[i] <= 0) {
				escreva("O valor digitado não é válido .Tente novamente.")
			} senao {
				escreva("valor adicionado com sucesso. pressione 'S' se dejesa continuar:\n")
				leia(resposta)
				limpa()
				se (resposta != 's' e resposta != 'S') pare
			}
		}

		para (inteiro i = 0; i < 5; i++) {
			se (compras[i] == 0) {
				descontoVetor[i] = 0
			} senao se (compras[i] == 500) {
				desconto[i] = 1 
				descontoVetor[i] = desconto[i]
			} senao se (compras[i] > 500) {
				desconto[i] = (compras[i] - 400)/100
				se (desconto[i] > 25) desconto[i] = 25
				descontoVetor[i] = desconto[i]
			} 			
		}
		
		escreva("Valor da compra | porcentagem de desconto | valor final \n")	
		
		para (inteiro i = 0; i < 5; i++) {
			valorDesconto = compras[i] / 100 * desconto[i]
			valorFinal[i] = compras[i] - valorDesconto
			
			escreva("R$ " + compras[i]  +  "\t            " +  descontoVetor[i] + "% \t    " +  "R$ " + valorFinal[i] + "\n")
		}

		para (inteiro i = 0; i < 5; i++) {
			totalCompra += valorFinal[i]
		}

		escreva("O valor total das compras é " + totalCompra)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1625; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {valorFinal, 22, 7, 10}-{compras, 25, 7, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */