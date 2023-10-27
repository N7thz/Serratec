import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src="https://i.redd.it/6k3jdtgv3qnb1.jpg" className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src="https://i.pinimg.com/564x/a4/a8/cf/a4a8cff2c71c6ad05bb16c5178ba72a0.jpg" className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Contador de Sabidas</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          O contador está em {count}
        </button>
        <p>
          Edite <code>src/App.jsx</code> save e teste.
        </p>
      </div>
      <p className="read-the-docs">
        Clique no "Logo ali" ou no "Eu sabo" para obter mais informações
      </p>
    </>
  )
}

export default App
