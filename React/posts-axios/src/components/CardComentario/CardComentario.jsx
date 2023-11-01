import { useEffect } from "react"
import { api } from "../../api/api"

const CardComentario = ({ autor, comentario, id, getPosts, likes }) => {

  const handleRemover = () => {
    api.delete(`/posts/${id}`)
    getPosts()

    const handleLike = () => {
      api.patch(`/posts/${id}`,() => {likes = likes + 1})
      getPosts()
    }

    return (
      <div style={{ borderWidth: '1px', borderColor: 'gray', border: 'solid', borderRadius: '10px', marginTop: '10px' }}>
        <b>{autor}</b>
        <p>{comentario}</p>
        <div onClick={handleLike}><button>Likes: {likes}</button>
          <button onClick={handleRemover}>Remover</button></div>
      </div>
    )
  }
}  

export default CardComentario