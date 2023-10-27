import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  const [listaDeTarefas, setListaDeTarefas] = useState([])
  const [tarefa, setTarefa] = useState('')

  const handleChangeTarefa = (e) => {
    
    setTarefa(e.target.value)
  }

  const handleIncluirTarefa = () => {

    setListaDeTarefas([...listaDeTarefas,tarefa])
  }

  const handleConcluir = (tarefaConcluida) => {

    setListaDeTarefas(listaDeTarefas.filter((value) => value != tarefaConcluida))

    alert(`A tarefa ${tarefaConcluida} foi concluída.`)
  }

  return (
    <>
      <input value={tarefa} onChange={handleChangeTarefa}/> 
      <button onClick={handleIncluirTarefa}>Incluir tarefa</button> 

      <hr />

      {listaDeTarefas.map((value) => (

        <div>
          {value}
          <button onClick={() => {handleConcluir(value)}}>Concluir</button>
        </div>
      ))}

    {/*<label>Lavar carro</label>
      <button>Concluido</button> */}
    </>
  )
}

export default App
