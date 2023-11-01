import { Navigate, useParams } from "react-router-dom"
import NavBar from "../components/navbar"

const Pessoa = () => {

    const { nome } = useParams()

    return (

        <>
            <NavBar/>
            {/* {nome === 'Raphael' ? <p>Você não é bem-vindo</p> :<p>Bem-vindo {nome}</p>}
            {condicao ? true : false} */}

            {/* {nome !== 'Raphael' && <p>Olá, {nome}</p> } */}

            {nome !== 'Raphael' ? <p>Ola, {nome}</p> : <Navigate to='/'/> }
        </>
    )
}

export default Pessoa