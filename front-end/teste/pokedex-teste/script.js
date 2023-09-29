const pokemonName = document.querySelector('.pokemon_name')
const pokemonNumber = document.querySelector('.pokemon_number')
const pokemonImage = document.querySelector('.pokemon_image')

const form = document.querySelector('.form')
const input = document.querySelector('.input_search')

const buttonPrev = document.querySelector('.btn-prev')
const buttonNext = document.querySelector('.btn-next')

const pokedex = document.querySelector('.pokedex')

let idAtual = 1


const fetchPokemon = async (pokemon) => {
    const apiResponse = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon.toLowerCase()}`)

    if (apiResponse.status === 200) {
        const data = await apiResponse.json()

        return data
    }  
}

const renderPokemon = async (pokemon) => {

    pokemonName.textContent = "Loading..."
    pokemonNumber.textContent = ""

    const data = await fetchPokemon(pokemon)

    if (data) {
        pokemonName.textContent = data.name
        pokemonNumber.textContent = data.id
        pokemonImage.src = data
        ['sprites']['versions']['generation-v']['black-white']['animated']['front_default']

        idAtual = data.id
    } else {
        pokemonName.textContent = "Not-found 😥"
        pokemonNumber.textContent = "?"

        pokemonImage.src = 'ditto-dancando.gif'

        idAtual = 1
    }

    input.value = ''
}

form.addEventListener('submit', (event) => {
    event.preventDefault()

    renderPokemon(input.value)
})

buttonPrev.addEventListener('click', () => {
    let number = parseInt(idAtual)
    
    console.log(number)

    if (number > 1 ) {
        renderPokemon((number - 1) + "")
    } else {
        renderPokemon("649")
    }
})

buttonNext.addEventListener('click', () => {

    let number = parseInt(idAtual)
    
    console.log(number)

    if (number < 649 ) {
        renderPokemon((number + 1) + "")
    } else {
        renderPokemon("1")
    }
})

renderPokemon("1")



