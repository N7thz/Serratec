import { useContext, useState, useEffect } from "react";
import { BiPlay, BiPause } from "react-icons/bi";
import { MusicaContext } from "../context/MusicaContext";

const PageMusica = ({ musica }) => {

    const { exist, song, musicas } = useContext(MusicaContext)
    const [playing, setPlaying] = useState(false)

    const handlePlay = () => {

        !playing ? song.play() : song.pause()

        setPlaying(!playing)
    }

    if (exist) {

        return (

            <div className='w-full '>
                <img className='w-full z-0 rounded-lg' src={musica.banner} alt="musica-banner" />
                <div className=' h-full m-3 flex items-center justify-between gap-2'>
                    <div>
                        <h1 className='text-7xl text-zinc-50'>{musica.nome}</h1>
                        <h2 className='text-5xl text-zinc-300'>{musica.artista}</h2>
                    </div>

                    {
                        playing ?
                            <BiPause onClick={handlePlay} className="bg-zinc-50 text-7xl rounded-full mr-5 hover: cursor-pointer active:scale-90" /> :
                            <BiPlay onClick={handlePlay} className="bg-zinc-50 text-7xl rounded-full mr-5 hover: cursor-pointer active:scale-90" />
                    }
                </div>
            </div>
        )
    } else {

        return (

            <>
                <div className="h-full flex items-center justify-center">
                    <h1 className="text-5xl text-zinc-400">
                        Sem músicas aki...
                    </h1>
                </div>
            </>
        )
    }
}

export default PageMusica