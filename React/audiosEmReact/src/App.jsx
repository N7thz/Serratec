import { useState } from 'react'
import musica from './assets/audios/safari-riot-vision.mp3'
import './App.css'

function App() {

  const audio = new Audio(musica)
  
  const handlePlay = () => {

    audio.play()
  }

  const handlePause = () => {

    audio.pause()
  }

  return (

    <>
      <div>
        <h1>teste de audios</h1>
        <audio src={musica}></audio>
        <div className='w-full flex justify-around'>
          <button onClick={handlePlay}>play</button>
          <button onClick={handlePause}>pause</button>
        </div>
      </div>
    </>
  )
}

export default App
