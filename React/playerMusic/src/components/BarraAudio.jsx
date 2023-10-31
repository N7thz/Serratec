import { ImPrevious2, ImNext2, ImShuffle, ImLoop2 } from "react-icons/im";
import { BiPlay } from "react-icons/bi";

const BarraAudio = () => {

    return (

        <div className='bg-green-400 w-2/4 flex flex-col justify-around items-center'>
            <div className='flex items-center justify-center gap-2 p-1'>
                <ImShuffle className='btns-audio' />
                <ImPrevious2 className='btns-audio' />
                <BiPlay className='bg-white text-4xl rounded-full' />
                <ImNext2 className='btns-audio' />
                <ImLoop2 className='btns-audio' />
            </div>
            <span className='flex w-5/6'>
                <p>0.00</p><input type="range" className='w-full mx-2' /><p>0.00</p>
            </span>
        </div>
    )
}

export default BarraAudio