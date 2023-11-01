import { Link } from "react-router-dom"

const NavBar = () => {

    return (

        <>
            <Link to={'/home'}>Pagina Principal</Link>
            <br />
            <Link to={'/contatos'}>Entre em contato conosco</Link>
            <br />
            <Link to={'/comentarios'}>Deixe seus comentarios</Link>
        </>
    )
}

export default NavBar