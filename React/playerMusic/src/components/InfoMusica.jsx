import { SiGithubsponsors } from "react-icons/si";

const InfoMusica = ({ musica }) => {

    return (
        <div className=' h-full w-1/4 flex items-center justify-around'>
            <img src={musica.capa} className='h-5/6 rounded-lg' alt={musica.nome} />
            <div className='flex gap-2 items-center'>
                <div>
                    <h1 className='text-zinc-50'>{musica.nome}</h1>
                    <h2 className='text-xs text-zinc-300'>{musica.artista}</h2>
                </div>
                <SiGithubsponsors className='cursor-pointer scale-110 text-zinc-50' />
            </div>
        </div>    
    )
}

export default InfoMusica