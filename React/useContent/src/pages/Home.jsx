import React, { useContext } from 'react'
import { ThemeContext } from '../context/ThemeContext'

export const Home = () => {

    const { theme, toggleTheme } = useContext(ThemeContext)

    return (
        <>
            <h1>Pagina inicial</h1>
            <h2>O tema atual é {theme} </h2>
            <button onClick={toggleTheme}>Mudar tema</button>
        </>
    )
}
