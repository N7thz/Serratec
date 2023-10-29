import { Button, Td, Tr } from "@chakra-ui/react"

const Contato = ({ contato,  }) => {
    const { nome, telefone, temWhatsapp, observacoes } = contato

    return (
        <Tr>
            <Td>{nome}</Td>
            <Td>{telefone}</Td>
            <Td>{temWhatsapp ? 'Sim' : 'Não'}</Td>
            <Td>{observacoes === '' ? '-' : observacoes}</Td>
            <Td><Button marginRight={'10px'} onClick={ () => {handleClickEditar(contato)} }>Editar</Button><Button onClick={() => { handleClickExcluir(telefone) }}>Excluir</Button></Td>
        </Tr>
    )
}

export default Contato