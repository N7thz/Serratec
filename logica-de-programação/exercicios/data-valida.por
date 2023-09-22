programa {
	funcao inicio() {
		inteiro dia, mes, ano

		escreva("--- Digite todos os valores em números.--- \n")
		escreva("Digite um dia: ")
		leia(dia)
		escreva("Agora digite um mês: ")
		leia(mes)
		escreva("Por fim digite um ano: ")
		leia(ano)
		
		se (mes == 2 e dia > 28) {
			escreva("[ERRO] Fevereiro tem apenas 28 dias.")
		} senao se (dia > 31 ou dia < 1 ou mes > 12 ou mes < 1 ou ano < 0) {
			escreva("[ERRO] A data que você digitou não é válida.")
		} senao se (dia > 30 e (mes == 4 ou mes == 6 ou mes == 9 ou mes == 11)) {
			escreva("[ERRO] O mês que você digitou tem apenas 30 dias.")
		} senao {
			limpa()
			escreva("A data " + dia + "/"  + mes +  "/" + ano + " é uma data válida.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {dia, 3, 10, 3}-{mes, 3, 15, 3}-{ano, 3, 20, 3};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */