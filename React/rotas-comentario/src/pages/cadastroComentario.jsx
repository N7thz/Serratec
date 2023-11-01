import { useState } from "react"

const CadastroComentario = () => {

    const [autor, setAutor] = useState('')
    const [comentario, setComentario] = useState('')

    const handleSave = () => {
        api.post('/post', {autor,comentario, likes: 0})
    }

    return (
        <>
            <form onSubmit={handleSave}>
                <label>Autor:</label> <br />
                <input onChange={(e) => {setAutor(e.target.value)}} />
                <br />
                <label>Comentário</label> <br />
                <textarea onChange={(e) => {setComentario(e.target.value)}}/>
                <br />
                <button type='submit'>Salvar</button>
                <button type='reset'>Limpar</button>
            </form>
        </>
    )
}

export default CadastroComentario