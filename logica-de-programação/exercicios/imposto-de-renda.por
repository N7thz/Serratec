programa {
	funcao inicio() {
		real salario,aliquota,aliqPorcem,parcela,impRenda
		inteiro dependentes

		aliquota = 0.0
		parcela = 0.0
		impRenda = 0.0
		
		escreva("Digite seu salário: ")
		leia(salario)
		
		escreva("Agora digite o numero de dependentes: ")
		leia(dependentes)

		se (salario > 2112 e salario < 2826.65) {
			aliquota = 7.5
			parcela = 158.4
		} senao se (salario > 2826.66 e salario < 3751.05) {
			aliquota = 15.0
			parcela = 370.4
		} senao se (salario > 3751.06 e salario < 4664.68) {
			aliquota = 22.5
			parcela = 651.73
		} senao se (salario > 4664.68) {
			aliquota = 27.5
			parcela = 884.96
		}
		
		limpa()
		impRenda = (salario * (aliquota/100)) - (parcela * dependentes)
		escreva("O salario é " + salario)
		escreva("O valor à ser pago no imposto de renda é " + impRenda + " Reais. ")
		escreva("A aliquota é de " + aliquota + "%")

		
		se (salario <= 2112 ou impRenda < 0) {
			limpa()
			escreva("Você não preceisa pagar o imposto de renda")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 870; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */