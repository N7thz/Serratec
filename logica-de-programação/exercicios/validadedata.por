/* teste
		inteiro dia = 22 + prazo, 
			   mes = 8, 
			   ano = 2024
*/

programa {

	inclua biblioteca Calendario --> cal
	
	funcao inicio() {
		escreva(validadeOrc())
	}

	funcao cadeia validadeOrc() {
		inteiro prazo = 7
		cadeia dataValidade
		inteiro dia = (cal.dia_mes_atual() + prazo), 
			   mes = cal.mes_atual(), 
			   ano = cal.ano_atual()
			   
		se(ano% 4 == 0 e mes == 2) {
			se(dia > 29) {
				dia = dia - 29
				mes++
			}	
		} senao se (dia > 28 e mes == 2) {
			dia = dia - 28
			mes++ 
		}
		
		se (dia > 31 ou dia < 1 ou mes > 12 ou mes < 1 ou ano < 0) {
			dia = dia - 31
			mes++
		} se (dia > 30 e (mes == 4 ou mes == 6 ou mes == 9 ou mes == 11)) {
			dia = dia - 30
			mes++
		} se(mes > 12) {
			mes = mes - 12
			ano++
		}
		
		dataValidade = dia + "/"  + mes +  "/" + ano + "\n"
		retorne dataValidade
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 174; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */