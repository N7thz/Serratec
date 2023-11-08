import { AiOutlineSound } from "react-icons/ai";

const CampoAudio = () => {

    return (

        <div className='w-1/4 flex items-center justify-around'>

            <AiOutlineSound className='btns-audio ml-2' />
            <input className='w-4/6  rounded-lg appearance-none bg-zinc-300' type="range" />
        </div>
    )
}

export default CampoAudio