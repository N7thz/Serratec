import { useState } from 'react'
import './App.css'
import './components/contato/contato'

function App() {

  const [contatos,setContatos] = useState([])

  const [nome, setNome] = useState('')
  const [telefone, setTelefone] = useState('')
  const [temWhatsapp, setTemWhatsapp] = useState(false)
  const [obs, setObs] = useState('')
  

  const handleIncluirContato = () => {

    const contatoAdicionado = {
      nome: nome,
      telefone: telefone,
      temWhatsapp: temWhatsapp,
      obs: obs
    }

    setContatos([...contatos,contatoAdicionado])

    handleApagarCampos()
  } 

  const handleApagarCampos = () => {

    setNome('')
    setTelefone('')
    setTemWhatsapp(false)
    setObs('')
  }

  const handleExcluirContato = (contatoExcluido) => {

    setContatos(contatos.filter((value) => value != contatoExcluido))
  }

  const handleAlterarContato = (contatoAlterado) => {

    setNome(contatoAlterado.nome)
    setTelefone(contatoAlterado.telefone)
    setTemWhatsapp(contatoAlterado.temWhatsapp)
    setObs(contatoAlterado.obs)

    handleExcluirContato(contatoAlterado)
  }

  const handleIncluirNome = (e) => {
    setNome(e.target.value)
  }

  const handleIncluirTelefone = (e) => {
    setTelefone(e.target.value)
  }

  const handleIncluirWhatsapp = (e) => {
    setTemWhatsapp(e.target.checked)
  }

  const handleIncluirObs = (e) => {
    setObs(e.target.value)
  }

  return (
    <>
      <div>   
          <h1>Lista de contatos</h1>

          <label>Nome</label>
          <input value={nome} onChange={handleIncluirNome}/><br />

          <label>Telefone</label>
          <input value={telefone} onChange={handleIncluirTelefone}/><br />

          <label>Observações</label>
          <input value={obs} onChange={handleIncluirObs}/><br />

          <label>Tem whatsapp</label>
          <input onChange={handleIncluirWhatsapp} type="checkbox" checked={temWhatsapp} /><br />

          <button onClick={handleIncluirContato}>Salvar</button>
          <input  onClick={handleApagarCampos} id='reset' type="reset" value={"Limpar"} />

          {contatos.map((value) => return }
      </div>
    </>
  )
}

export default App
