import React from 'react';
import styled from 'styled-components';

const StyledForm = styled.form`

    width: 500px;
    height: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 32px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    border: 2px solid #444;
    border-radius: 16px;
    background: #f2f2f2;
    color: #444;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    .campo {

        width: 90%;
        display: flex;
        justify-content: space-around;
        
        input {

            width: 80%;
            background: transparent;
            border: none;
            border-bottom: 1px solid #444;
        }
    }

    button {

        width: 40%;
        height: 10%;
        font-size: 1rem;
        background-color: #444;
        color: #f2f2f2;
        border-radius: 4px;
        cursor: pointer;

        &:hover {
            transform: scale(1.1);
            box-shadow: 0 3px 3px #00000048;
        }

        &:active {
            transform: none;
            box-shadow: none;
        }
    }
`;

export const Form = () => {

    return (
        <>
            <StyledForm>

                <h1>Login</h1>

                <div className='campo'>
                    <label>E-mail: </label>
                    <input />
                </div>

                <div className='campo'>
                    <label>Senha: </label>
                    <input />
                </div>

                <button>Confirmar</button>

            </StyledForm>
        </>
    )
}