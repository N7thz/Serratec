/*
Uma loja de ferramentas contratou você para criar um relatório de orçamento para os seus clientes.
Os produtos que ela vende são:

. Parafusos
. Arruelas
. Porcas
. Chaves de fenda
. Brocas
. Buchas

É necessário informar a quantidade de cada um dos produtos.
Calcular o total bruto a pagar e perguntar a forma de pagamento.

/FUNCAO METODO DE PAGAMENTO
Se for a vista, o total sofrerá um desconto de 5%.
Se for no cartão, o total não sofrerá alteração.
Se for à prazo, o total sofrerá um acréscimo de 5%.

No relatório deve conter os seguintes dados:

Nome do cliente
Validade do orçamento
Código dos produtos
Descrição dos produtos
Quantidade dos produtos
Valor unitário dos produtos
Percentual de desconto ou acréscimo dos produtos
Valor total dos produtos
Valor total bruto do orçamento 
Percentual de desconto do orçamento
Valor líquido do orçamento

Exemplo:

Nome do cliente:               Validade:

cód.produto | Nome Produto | vl unit   |  Desc/Acrésc  |   vl Total
1
2
3
4
5
6

Total Bruto =
Desc/Acrésc = 
Total Líquido = 

CARACTERISTISCAS DO PARAFUSO
0 COD PRODUTO
1 NOME
2 VALOR UNITADO
3 Quantidade Estoque

TEMOS 6 PRODUTOS CADA UM COM 3 CARACTERISTICAS

para incluir o produto no orçamento o que eu preciso 
0 nome do produto
1 valor unitario do produto
2 quantidade do produto

jose, data 

*/
programa{
	
	inclua biblioteca Util --> utl
	inclua biblioteca Calendario --> cal
	inclua biblioteca Tipos --> tip
	
	const inteiro TAM_LINHA = 6
	const inteiro TAM_COL = 4
	const inteiro TAM_COL_ORCAMENTO = 3
	
	funcao inicio(){
		
	caracter opcao
	logico nParar = verdadeiro	
	cadeia listaProdOrcamento[TAM_LINHA][TAM_COL_ORCAMENTO],nomeCliente, dataOrc//dd/mm/yyyy
	cadeia baseProdutos[TAM_LINHA][TAM_COL] = {
										//COD PRODUTO,NOME.VALOR UNITARIO, QUANTIDADE ESTOQUE
										{"1","Parafuso","1.5 ","8"},
										{"2","Arruelas","0.5 ","8"},
										{"3","Porcas","0.3 ","8"},
										{"4","Chv fenda","15.0","8"},
										{"5","Brocas","3.0 ","8"},
										{"6","Buchas","0.25","8"}
									 }

	
	
	faca{
		limpa()
		escreva("\nDeseja fazer um novo orcamento?(S/N)")
		leia(opcao)
		se(opcao=='s'){
			escreva("\nInsira Nome do Cliente: ")
			leia(nomeCliente)
			dataOrc = cal.dia_mes_atual()+"/"+cal.mes_atual()+"/"+cal.ano_atual()
			menu(baseProdutos)
			incluirProduto(baseProdutos,listaProdOrcamento)
		}
		senao{
			nParar=falso
		}
	}enquanto(nParar)

	para(inteiro i=0; i<TAM_LINHA;i++){
		escreva("\n")
		para(inteiro j=0; j<TAM_COL;j++){
			escreva("| ",listaProdOrcamento[i][j] ,"\t\t |")
		}
	}
	}
	
	funcao menu(cadeia matriz[][]){
		escreva("\n------------------------------------------------------------------------------------")
		escreva("\n\t\t Item desejado")
		escreva("\n------------------------------------------------------------------------------------")
		escreva("\nCOD PRODUTO\t\tNOME PRODUTO\t\tVALOR UNITARIO\t\tQUANTIDADE ESTOQUE")
		escreva("\n------------------------------------------------------------------------------------")
		para(inteiro i=0; i<TAM_LINHA;i++){
			escreva("\n")
			para(inteiro j=0; j<TAM_COL_ORCAMENTO;j++){
				//escreva("\n i:",i," J: ",j," Valor: ",matriz[i][j])
				escreva("| ",matriz[i][j] ,"\t\t |")
			}
		}
		escreva("\n------------------------------------------------------------------------------------")
	}

	funcao incluirProduto(cadeia matrizBase[][],cadeia &matrizORC[][]){
		
		logico nParar = verdadeiro
		inteiro codProduto,quantidadeProd,contadorLinha
		caracter opcao = 'n'
		contadorLinha = 0
		
		//quantidade do produto
		faca{
			escreva("\nVocê tem direito a mais ",TAM_LINHA-contadorLinha," inserções de Produto.")
			
			se ((TAM_LINHA-contadorLinha)<1){
				nParar=falso
			}
			senao se(opcao=='s'){
				nParar=falso
			}
			senao{
				escreva("\nInsira o Cod do produto: ")
				leia(codProduto)
				escreva("\nInsira quantidade do produto: ")
				leia(quantidadeProd)
				para(inteiro i=0;i<TAM_LINHA;i++){
					se (matrizBase[i][0]==tip.inteiro_para_cadeia(codProduto,10)){
						//inserir nome produto e valor unitario
						//buscar codProduto na Base ' col 0'
						matrizORC[contadorLinha][0] = matrizBase[i][1]
						matrizORC[contadorLinha][1] = matrizBase[i][2]
						matrizORC[contadorLinha][2] = tip.inteiro_para_cadeia(quantidadeProd,10)
						contadorLinha++
					}
				}
				escreva("\nDeseja parar?(S/N)")
				leia(opcao)
			}	
		}enquanto(nParar)	
	}
		
	funcao metodoPagamento(){
		
	}

	funcao cadeia validadeOrc() {
		inteiro prazo = 7
		inteiro dia = (cal.dia_mes_atual() + prazo), 
			   mes = cal.mes_atual(), 
			   ano = cal.ano_atual()
		cadeia resultado	   
			   
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
		resultado = (dia + "/"  + mes +  "/" + ano + "\n")
		retorne resultado 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2054; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */