import NavBar from "../components/navbar"
import { Outlet } from "react-router-dom"

const Home = () => {
    
    return (

        <>
            {/* <h1>Seja bem-vindo</h1> */}
            <NavBar />

            <Outlet />
        </>
    )
} 

export default Home