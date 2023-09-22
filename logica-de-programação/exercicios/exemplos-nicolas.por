programa
{
    
    funcao inicio()
    {
        cadeia nomes[3] = {"Nicolas","Fulano", "Cliclano"} // [ "Nicolas" - 0, "Fulano" - 1, "Cliclano" - 2 ] - tamanho/length 3
        inteiro idades[3] = {29,16,54}

        cadeia nomesFiltrados[3]
        inteiro idadesFiltradas[3]
                
        para (inteiro i = 0; i < 3; i++) {
            se(idades[i] >= 18) {
                nomesFiltrados[i] = nomes[i]
                idadesFiltradas[i] = idades[i]
            }
        }

        para (inteiro i = 0; i < 3; i++) {
            escreva(nomesFiltrados[i], idadesFiltradas[i])
        }
    }
}

programa {
    // Sem retorno e sem parametro
    // Sem retorno e com parametro
    // Com retorno e sem parametro
    // Com retorno e com parametro

    funcao inicio() {
        real numeroInserido1, numeroInserido2, resultado
        
        escreva("Digite o primeiro número: ")
        leia(numeroInserido1)
        escreva("Digite o segundo número: ")
        leia(numeroInserido2)

        somar(numeroInserido1, numeroInserido2)
        subtrair(numeroInserido1, numeroInserido2)

        resultado = multiplicar(numeroInserido1, numeroInserido2)
        escreva(resultado + "\n")
    }

    funcao somar(real numero1, real numero2) {
        real resultado = numero1 + numero2
        escreva(resultado + "\n")
    }

    funcao subtrair(real numero1, real numero2) {
        real resultado = numero1 - numero2
        escreva(resultado + "\n")
    }

    funcao real multiplicar(real numero1, real numero2) {
        retorne numero1 * numero2
   }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1572; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */