import React from 'react'

import { useContext } from 'react'
import { ThemeContext } from '../context/ThemeContext'

export const Contact = () => {

    const { theme } = useContext(ThemeContext)

    return (

        <>
            <h1>Pagina de contatos</h1>
            <h2>O tema atual é {theme} </h2>
        </>
    )
}

