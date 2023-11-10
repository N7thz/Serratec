import { useContext, useState } from 'react'

//#region Components
import Musica from './components/Musica'
import InfoMusica from './components/InfoMusica'
import BarraAudio from './components/BarraAudio'
import CampoAudio from './components/CampoAudio'
import PageMusica from './components/pageMusica'
//#endregion

//#region Icons
import { RiHome2Line } from "react-icons/ri";
import { MdSearch } from "react-icons/md";
import { HiMiniBars3CenterLeft } from "react-icons/hi2";
//#endregion

import { MusicaContext } from './context/MusicaContext'

function App() {

  const { musica , musicas } = useContext(MusicaContext)

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
          <PageMusica musica={musica}/> 
        </main>
      </div>
      <footer className='bg-zinc-700 h-20 w-full absolute bottom-0 flex '>
        <InfoMusica musica={musica} />
        <BarraAudio />
        <CampoAudio />
      </footer >
    </div >
  )
}

export default App