import React from 'react';
import styled from 'styled-components';
import BtnMenu from './BtnMenu';

const StyledForm = styled.form`

    width: 400px;
    height: 300px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    background-color: #f2f2f2;
    border: 2px solid #444;
    border-radius: 16px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    input::placeholder {

        text-align: center;
        color: black;
    }

    #email:focus {
        
        outline: none;
        border: none;
        box-shadow: 3px 3px 3px inset black;
    }

    button {

        width: 120px;
        height: 40px;
        background-color: white;
        border-radius: 8px;
    }

`

const Form = () => {

    return (
        <>
            <StyledForm>

                <h1>Login</h1>

                <input id='email' placeholder='E-mail'/>

                <input placeholder='Senha'/>

                <button>Confirmar</button>

            </StyledForm>
        </>
    )
}

export default Form