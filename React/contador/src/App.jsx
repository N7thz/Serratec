import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  const [count, setCount] = useState(0)
  const [newValue, setNewValue] =  useState(0)

  const handleDecrementar = () => {
    setCount(count - 1)
  }

  const handleIncrementar = () => {
    setCount(count + 1)
  }

  const handleReset = () => {
    setCount(0)
  }

  const handleNewValue = () => {
    setCount(newValue)
  } 
  
  const handleChangeNewValue = (e) => {
    setNewValue(Number(e.target.value))
  }

  return (
    <div>
      <h3>Contador boladão</h3>
      <p>{count}</p>
      <button onClick={handleDecrementar}>Decrementar</button>
      <button onClick={handleIncrementar}>Incrementar</button>
      <br />
      <button onClick={handleReset}>Resetar</button>
      <hr />
      <input type='number' min={0} onChange={handleChangeNewValue}/>
      <button onClick={handleNewValue}>Alterar</button>
    </div>
  )
}

export default App
