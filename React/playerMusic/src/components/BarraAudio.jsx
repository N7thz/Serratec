import { ImPrevious2, ImNext2, ImShuffle, ImLoop2 } from "react-icons/im";
import { BiPlay } from "react-icons/bi";

const BarraAudio = () => {

    return (

        <div className='w-2/4 flex flex-col justify-around items-center'>
            <div className='flex items-center justify-center gap-2 p-1'>
                <ImShuffle className='btns-audio' />
                <ImPrevious2 className='btns-audio' />
                <BiPlay className='bg-white text-4xl rounded-full hover: cursor-pointer active:scale-90' />
                <ImNext2 className='btns-audio' />
                <ImLoop2 className='btns-audio' />
            </div>
            <span className='flex w-5/6 items-center'>
                <p>0.00</p>
                <input type="range" className='w-full h-2 mx-2 rounded-lg appearance-none bg-zinc-300'/>
                <p>0.00</p>
            </span>
        </div>
    )
}

export default BarraAudio