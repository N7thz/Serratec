/*
9) No portugol, crie um programa com dois vetores.
O vetor 01 com tamanho 10, onde possui o seguinte conteúdo:
	[50, 20, 90, 80, 60, 10, 70, 40, 30, 01]

O vetor 02 com tamanho 20, sem conteúdo, mas de mesmo tipo.

Em um laço, transfira o conteúdo do vetor que possui os 
números para o outro vetor que ainda não foi inicializado.

Em seguida, crie uma função que receba um vetor como 
parâmetro e que seja capaz de escrever no console o 
conteúdo de qualquer vetor.
Execute a função de modo que o conteúdo dos dois vetores 
sejam apresentados em tela, mas somente os números maiores 
que zero.
*/
programa {	
	inteiro vetorInicial[10] = {50, 20, 90, 80, 60, 10, 70, 40, 30, 01}
	inteiro vetor02[20]
	
	funcao inicio() {
	
		recebeValores()
		escreveVetor(vetorInicial[])
		escreveVetor(vetor02[])
	}

	funcao escreveVetor(inteiro vetor[]) {
		para (inteiro i = 0; i < 10; i++) {
			escreva(vetor[i],"\t")		   	
		}
	}

	funcao recebeValores() {
		para (inteiro i = 0; i < 10; i++) {
			vetor02[i] = vetorInicial[i]		   
		}
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 801; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */