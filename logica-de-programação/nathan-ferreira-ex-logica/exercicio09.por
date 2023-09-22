/*
9) Faça um programa que peça o nome de 10 pessoas e a sua idade.
Armazene os nomes num vetor e a idade em outro vetor.
Crie um laço para fazer essas soliciações.
Crie um menu que permita ao usuário deicidir se quer incluir, alterar ou excluir os dados dos vetores.
Excluir significa limpar os dados (colocar vazio ou zero).
A edição somente será permitida se o nome não estiver vazio. Nesse caso, deverá efetuar a inclusão.
Crie um menu para organizar as funções.

Exemplo:

--------------------------------
      Cadastro de pessoas
--------------------------------
 1 - Incluir
 2 - Alterar
 3 - Excluir
 4 - Sair
--------------------------------
*/

programa {
	const inteiro INDICE = 10
		
	cadeia nome[INDICE]
	inteiro idade[INDICE]
	inteiro numero = 0
	
	
	funcao inicio() {
		header()
		menu()
		limpa()
		escolhaCaso(numero)
	}

	funcao header() {
		escreva("----------------------------------------------\n",
			   "		Cadastro de pessoas \n",
			   "----------------------------------------------\n")
	}

	funcao inteiro menu() {
		
		escreva(" 1 - Incluir \n",
			   " 2 - Alterar \n",
			   " 3 - Excluir \n",
			   " 4 - Sair \n")
		leia(numero)

		retorne numero
	}

	funcao escolhaCaso(inteiro case) {
		
		escolha (case) {
			caso 1:
				incluirValores() pare
			caso 2:
				alterarValores() pare
			caso 3:
				excluirValores() pare
			caso 4:
				escreva("voce saiu do programa.\n") pare
			caso contrario:
				escreva("Valor digitado invalido")
		}
	}	

	funcao incluirValores() {

		para (inteiro i = 0; i < INDICE; i++) {
			limpa()
			escreva("Digite o nome da ",i + 1, " pessoa: ")
			leia(nome[i])
			escreva("Digite a idade da ",i + 1, " pessoa: ")
			leia(idade[i])
		}
								
		limpa()
		escreva("Os valores foram adcionados.\n")
		escreva("\n")
		exibirVetores()
		escreva("\n")
		repeticao()
	}

	funcao alterarValores() {
		cadeia antigoNome,novoNome
		inteiro antigoIdade,novoIdade
		inteiro respostaAlt
		
		verificarInclusao()
		
		limpa()
		escreva("\nQue dado você deseja alterar?\n",
    			   "1 - Nome\n",
    			   "2 - Idade\n")
    			   
		leia(respostaAlt)
				
   		se (respostaAlt == 1) { 
   			
			escreva("Qual nome antigo você deseja alterar: ")
			leia(antigoNome)
			escreva("Qual o novo nome que você deseja alterar: ")
   			leia(novoNome)
   			
   			para (inteiro i = 0; i < INDICE; i++) {
   				se (nome[i] == antigoNome) {
   					nome[i] = novoNome
   				}
   			}
   		} senao se (respostaAlt == 2) {
   			
   			escreva("Qual nome antigo você deseja alterar: ")
   			leia(antigoNome)
   			escreva("Para qual idade você vai adicionar: ")
   			leia(novoIdade)
   			
   			para (inteiro i = 0; i < INDICE; i++) {
   				se (nome[i] == antigoNome) {
   					idade[i] = novoIdade
   				}
   			}
   		} senao {
   			escreva("Valor invalido")
   		}

		limpa()
		escreva("Os valores foram alterados.\n")
   		exibirVetores()
   		repeticao()
   		
	}

	funcao repeticao() {
		menu()
		escolhaCaso(numero)
	}

	funcao excluirValores() {
		caracter resposta
		
		verificarInclusao()
		limpa()
		escreva("Você tem certeza que deseja excluir? [S/N]")	
		leia(resposta)	

		se (resposta == 's' ou resposta == 'S') {
			para (inteiro i = 0; i < INDICE; i++) {
				nome[i] = " "
				idade[i] = 0
			}
		}

		escreva("\nOs valores foram excluidos\n")
		escreva("\n")
		exibirVetores()
		escreva("\n")
		repeticao()
	}

	funcao verificarInclusao() {	
		caracter resposta = 's'
			
		para (inteiro i = 0; i < INDICE; i++) {			
			se (nome[i] == "" ou idade[i] == 0) {
				escreva("Nenhum valor foi criado.") 
				escreva("Deseja criar uma lista de nomes? [s/n]")
				leia(resposta) 
				se(resposta == 's' ou resposta == 'S') 	incluirValores() 
					limpa()
					repeticao()					
			}
		}
	}

	funcao exibirVetores() {
		para (inteiro i = 0; i < INDICE; i++) {
			escreva("| " + nome[i])
			escreva(" , " + idade[i]+ " |\n")

		}
	}

//fim do programa
}

	

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 695; 
 * @DOBRAMENTO-CODIGO = [36, 42, 53, 69, 87, 136, 141, 163, 178];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nome, 25, 8, 4}-{idade, 26, 9, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */