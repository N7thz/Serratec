import { SiGithubsponsors } from "react-icons/si";

const InfoMusica = ({ musica }) => {

    return (
        <div className='bg-red-400 h-full w-1/4 flex items-center justify-around'>
            <img src={musica.capa} className='h-5/6 rounded-lg' alt={musica.nome} />
            <div className='flex gap-2 items-center'>
                <div>
                    <h1>{musica.nome}</h1>
                    <h2 className='text-xs'>{musica.artista}</h2>
                </div>
                <SiGithubsponsors className='cursor-pointer scale-110' />
            </div>
        </div>    
    )
}

export default InfoMusica