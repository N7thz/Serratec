import { Button, Checkbox, Divider, Input, Table, TableContainer, Tbody, Text, Th, Thead, Tr, Td} from '@chakra-ui/react'
import { useState } from 'react'
import Contato from './components/Contato/Contato'

function App() {
  
  const [listaDeContatos, setListaDeContatos] = useState([])
  const [nome, setNome] = useState('')
  const [telefone, setTelefone] = useState('')
  const [temWhatsapp, setTemWhatsap] = useState(false)
  const [observacoes, setObservacoes] = useState('')

  const handleChangeNome = (event) => {
    setNome(event.target.value)
  }

  const handleChangeTelefone = (event) => {
    setTelefone(event.target.value)
  }

  const handleChangeObservacoes = (event) => {
    setObservacoes(event.target.value)
  }

  const handleChangeTemWhatsapp = (event) => {
    setTemWhatsap(event.target.checked)
  }

  const handleClickLimpar = () => {
    setNome('')
    setTelefone('')
    setTemWhatsap(false)
    setObservacoes('')
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    setListaDeContatos([...listaDeContatos, { nome, telefone, temWhatsapp, observacoes }])
    handleClickLimpar()
  }

  const handleClickExcluir = (telefone) => {
    setListaDeContatos(listaDeContatos.filter((contato) => contato.telefone !== telefone))
  }

  const handleClickEditar = ({ nome, telefone, temWhatsapp, observacoes }) => {
    setNome(nome)
    setTelefone(telefone)
    setTemWhatsap(temWhatsapp)
    setObservacoes(observacoes)

    handleClickExcluir(telefone)
  }

  return (
    <>
    <form onSubmit={handleSubmit} onReset={handleClickLimpar}>
      <Text>Nome</Text>
      <Input value={nome} onChange={handleChangeNome} />

      <Text>Telefone</Text>
      <Input value={telefone} onChange={handleChangeTelefone}/>

      <Text>Tem whatsapp</Text>
      <Checkbox isChecked={temWhatsapp} onChange={handleChangeTemWhatsapp} />

      <Text>Observações</Text>
      <Input value={observacoes} onChange={handleChangeObservacoes} marginBottom={'20px'}/>

      <Button type='submit' marginRight={'10px'}>Salvar</Button>
      <Button type='reset'>Limpar Formulário</Button>
      <Divider mt={'30px'}/>

      <TableContainer>
        <Table size='sm'>
          <Thead>
            <Tr>
              <Th>Nome</Th>
              <Th>Telefone</Th>
              <Th>Tem Whatsapp</Th>
              <Th>Observações</Th>
              <Th>Ações</Th>
            </Tr>
          </Thead>
          <Tbody>
            {listaDeContatos.map((contato) => <Contato contato={contato} handleClickEditar={handleClickEditar}/>)}
          </Tbody>    
        </Table>
      </TableContainer>     
    </form>
    </>
  )
}

export default App
