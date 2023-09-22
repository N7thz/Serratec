//coloca os valores em caixa alta
function nomesMap() {
    //vetor de nomes
    let nomes = ["rafael", "josé", "maria", "carlos", "thiago"]
    
    //Novo vetor para receber o map 
    let nomesMap = nomes.map(function(nomes) {
        return nomes.toUpperCase()
    })
    
    console.log(`Os nomes em caixa alta são: ${nomesMap}`)
}

//dobra os valores do vetor
function dobravalores() {
    //vetor de numeros
    let numeros = [2, 4, 12, 1, 3, 45, 9]

    //Novo vetor para receber o map 
    let numdoble = numeros.map(function(numeros) {
        return numeros * 2
    })

    console.log(`Os valores dobrados são: ${numdoble}`)
}

nomesMap()
dobravalores()


