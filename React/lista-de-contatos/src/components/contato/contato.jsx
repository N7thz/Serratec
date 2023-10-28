const Contato = ({contato}) => {

    const {nome, telefone, temWhatsapp, obs} = props.contato
    
    return (
        <p> 
            <hr />
            Nome : {value.nome} <br />
            Telefone : {value.telefone} <br />
            Tem Whatsapp : {value.temWhatsapp ? "sim" : "nao"} <br />
            Obs : {value.obs === "" ? "-" : value.obs} <br />

            <button onClick={() => {handleExcluirContato(value)}}>Excluir</button>
            <button onClick={() => {handleAlterarContato(value)}}>Alterar</button>
            <hr /> <br /><br />
        </p>
    )
}

export default Contato