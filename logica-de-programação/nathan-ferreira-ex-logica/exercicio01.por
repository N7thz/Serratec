/*
1) Faça um programa que receba a idade de 15 pessoas e 
que calcule e mostre:
a) A quantidade de pessoas em cada faixa etária;

b) A percentagem de pessoas na primeira e na última 
faixa etária, com relação ao total de pessoas: 

Até 15 anos
De 16 a 30 anos
De 31 a 45 anos
De 46 a 60 anos
Acima de 61 anos

*/
programa {
	inclua biblioteca Tipos --> tip
	inclua biblioteca Util --> utl
	inclua biblioteca Matematica --> math

	funcao inicio() {
		exercicio01()
	}


	funcao exercicio01() {
		const inteiro TAM = 15
		real porcenFaixa15,porcenFaixa61
		inteiro idades[TAM] ,contador = 0
		inteiro faixa15 = 0,
			   faixa16A30 = 0,
			   faixa31A45 = 0,
			   faixa46A60 = 0,
			   faixa61 = 0		   

		para (inteiro i = 0; i < TAM; i++) {
			limpa()
			escreva("Digite " + (i+1) + " idade: ")
			leia(idades[i])

			contador = idades[i]
			
			se(contador >= 0 e contador <= 15) {
				faixa15++
			} senao se (contador <= 30) {
				faixa16A30++
			} senao se (contador <= 45) {
				faixa31A45++
			} senao se (contador <= 60) {
				faixa46A60++
			} senao {
				faixa61++
			}
		}	
		
		limpa()

		porcenFaixa15 = faixa15 * 100 / TAM
		porcenFaixa61 = faixa61 * 100 / TAM
		
		escreva("Até 15 anos :" + faixa15 + "\n")	
		escreva("De 16 a 30 anos :" + faixa16A30 + "\n")	
		escreva("De 31 a 45 anos :" + faixa31A45 + "\n")	
		escreva("De 46 a 60 anos :" + faixa46A60 + "\n")	
		escreva("Acima de 61 anos :" + faixa61 + "\n")
		escreva(porcenFaixa15 + "% das idades estão entre 0 e 15." )
		escreva("e " + porcenFaixa61 + "% das idades são maiores que 60.")
	}
}
	