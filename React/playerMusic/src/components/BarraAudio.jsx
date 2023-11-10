import { ImPrevious2, ImNext2, ImShuffle, ImLoop2 } from "react-icons/im";
import { BiPlay, BiPause } from "react-icons/bi";
import { useContext, useState } from "react";
import { MusicaContext } from "../context/MusicaContext";

const BarraAudio = () => {

    const { musica, setMusica, song, musicas } = useContext(MusicaContext)
    const [playing, setPlaying] = useState(false)
    const [duracao, setDuracao] = useState(0)
    const [time, setTime] = useState(0)

    const handleChangeTime = () => {

        setTime(song.currentTime)
    }

    const handlePlay = () => {

        !playing ? song.play() : song.pause()

        setPlaying(!playing)
    }

    const handlePrev = () => {

        if (musica == musicas[0]) {

            setMusica(musicas[4])
        } else {

            const tocando = musicas.find((musicaPlaying) => musicaPlaying.id == musica.id)
            const index = musicas.indexOf(tocando)

            if (index == 0) {

                setMusica(musicas[4])
            } else {

                setMusica(musicas[index - 1])
            }
        }
    }

    const handleNext = () => {

        if (musica == musicas[4]) {

            setMusica(musicas[0])
        } else {

            const tocando = musicas.find((musicaPlaying) => musicaPlaying.id == musica.id)
            const index = musicas.indexOf(tocando)

            if (index == 4) {

                setMusica(musicas[0])
            } else {

                setMusica(musicas[index + 1])
            }
        }
    }

    return (

        <div className='w-2/4 flex flex-col justify-around items-center'>
            <div className='flex items-center justify-center gap-2 p-1'>
                <ImShuffle className='btns-audio' />
                <ImPrevious2 onClick={handlePrev} className='btns-audio' />
                {
                    !playing ?
                        <BiPlay onClick={handlePlay} className='bg-white text-4xl rounded-full hover: cursor-pointer active:scale-90' /> :
                        <BiPause onClick={handlePlay} className='bg-white text-4xl rounded-full hover: cursor-pointer active:scale-90' />
                }
                <ImNext2 onClick={handleNext} className='btns-audio' />
                <ImLoop2 className='btns-audio' />
            </div>
            <span className='flex w-5/6 items-center'>
                <p>0.00</p>
                <input value={time} onChange={handleChangeTime} type="range" className='w-full h-2 mx-2 rounded-lg appearance-none bg-zinc-300' />
                <p>0.00</p>
            </span>
        </div>
    )
}

export default BarraAudio