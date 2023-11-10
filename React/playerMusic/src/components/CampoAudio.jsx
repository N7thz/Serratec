import { useContext, useState } from "react";
import { AiOutlineSound } from "react-icons/ai";
import { MusicaContext } from "../context/MusicaContext";
import { MdOutlineVolumeOff, MdOutlineVolumeUp } from "react-icons/md";

const CampoAudio = () => {

    const [ volume, setVolume ] = useState(80)
    const { song } = useContext(MusicaContext)
    const [ muted, setMuted ] = useState(false)

    const mudo = new Audio(song)

    const handleChangeVolume = (e) => {
    
        setVolume(e.target.value)
        song.volume = (volume / 100)

        if ( volume < 5 ) {

            song.volume = 0
            setMuted(true)
        } else {

            song.volume = (volume / 100)
            setMuted(false)
        }
    }

    const handleMuted = () => {

        !muted ? song.volume = 0 : song.volume = (volume / 100)

        setMuted(! muted )
    }

    return (

        <div className='w-1/4 flex items-center justify-around'>

            {
                muted ? 
                <MdOutlineVolumeOff onClick={handleMuted} className='btns-audio ml-2' /> :
                <MdOutlineVolumeUp onClick={handleMuted} className='btns-audio ml-2' />
            }

            <input value={volume} min={0} max={100} onChange={handleChangeVolume} className='w-4/6 rounded-lg appearance-none bg-zinc-300' type="range" />
        </div>
    )
}

export default CampoAudio