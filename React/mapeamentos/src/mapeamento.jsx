import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Aluno from './components/Aluno.jsx'

function App() {
  const alunos = [
    {nome: "Raphael", idade: "29", linguagem: "javascript",cor:"blue", situacao: "aprovado"},
    {nome: "Nathan", idade: "22", linguagem: "javascript",cor:"red", situacao: "aprovado"},
    {nome: "Mauro", idade: "30", linguagem: "Python",cor:"green", situacao: "reprovado"},
  ]

  return (
    <>
      
      {alunos.map((value) => (
        <div style={{background: value.cor}}>
          <p>Nome: {value.nome} </p>
          <p>idade: {value.idade} </p>
          <p>Linguagem preferida: {value.linguagem} </p>
          <p>Cor preferida: {value.cor}</p>
          <hr />
        </div>
      ) )}  
    </>
  )
}

export default App
