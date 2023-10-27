import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  const [count, setCount] = useState(0)
  //count[0] -> valor do estado
  //count[1] -> Funcao responsavel por alterar o estado

  function cliqueDoButao() {
    
    setCount(count + 1)
  }
  
  return (
    <div>
      <h1>Contador</h1>
      <p>{count}</p>
      <button onClick={cliqueDoButao}>Incrementar</button>
      outra opção usando arrow function
      <button onClick={() => setCount(count + 1)}>Incrementar</button>
    </div>
  )
}

export default App
