import { useState } from 'react'

//#region Components
import Musica from './components/Musica'
import InfoMusica from './components/InfoMusica'
import BarraAudio from './components/BarraAudio'
//#endregion

//#region Icons
import { RiHome2Line } from "react-icons/ri";
import { MdSearch } from "react-icons/md";
import { HiMiniBars3CenterLeft } from "react-icons/hi2";
import { ImVolumeMute2 } from "react-icons/im";
import { ImVolumeHigh } from "react-icons/im";
import { BiDotsHorizontalRounded, BiPlay } from "react-icons/bi";
import { BiPause } from "react-icons/bi";
//#endregion

//#region Imagem
import goatImg from './assets/imgs/goat.jpg'
import pomboImg from './assets/imgs/erenPombo.jpg'
import spiderVerseImg from './assets/imgs/spiderverse.png'
import valorantImg from './assets/imgs/valorant.png'
import motoserraImg from './assets/imgs/chainsaw-man-op.jpg'
//#endregion Imagens

//#region Audios
import goatAudio from './assets/audios/polyphia-G.O.A.T.mp3'
import pomboAudio from './assets/audios/eren-pombo.mp3'
import spiderVerseAudio from './assets/audios/spider-man-annihilate.mp3'
import valorantAudio from './assets/audios/safari-riot-vision.mp3'
import motoserraAudio from './assets/audios/chainsaw-man.mp3'
//#endregion

function App() {

  const [nome, setNome] = useState('')
  const [artista, setArtista] = useState('')
  const [capa, setCapa] = useState('')

  const goat = {

    nome: "G.O.A.T",
    artista: "Polyphia",
    capa: goatImg,
    musica: goatAudio
  }

  const pombo = {

    nome: "The Rumbling",
    artista: "Eren Pombo",
    capa: pomboImg,
    musica: pomboAudio
  }

  const spiderVerse = {

    nome: "Annihalate",
    artista: "Miranha",
    capa: spiderVerseImg,
    musica: spiderVerseAudio
  }

  const valorant = {

    nome: "Visions",
    artista: "Safari",
    capa: valorantImg,
    musica: valorantAudio
  }

  const motoserra = {

    nome: "Kick Back",
    artista: "Randandan",
    capa: motoserraImg,
    musica: motoserraAudio
  }

  const musicas = [goat, pombo, spiderVerse, valorant, motoserra]

  return (

    <div className='min-h-screen mx-auto overflow-hidden'>

      <div className='flex items-center justify-around gap-2 h-[70vw] min-w-full bg-zinc-800'>
        <aside className='h-[87%] w-1/4 bg-zinc-700 ml-2 rounded-lg'>

          <ul className='h-1/6'>

            <li className='itens rounded-t-lg'>
              <RiHome2Line className='ml-3' /> Início
            </li>
            <li className='itens'>
              <MdSearch className='ml-3' /> Pesquisa
            </li>
            <li className='itens'>
              <HiMiniBars3CenterLeft className='ml-3' /> Biblioteca
            </li>
          </ul>

          <div className='mt-20'>
            {musicas.map((musica) => <Musica musica={musica} />)}
          </div>

        </aside>
        <main className='bg-zinc-700 h-[87%] w-3/4 mr-2 rounded-lg'>
          
        </main>
      </div>
      <footer className='bg-zinc-700 h-20 w-full absolute bottom-0 flex'>
        <InfoMusica musica={spiderVerse}/>
        <BarraAudio />
        <div className='w-1/4'></div>
        
      </footer >
    </div >
  )
}

export default App

