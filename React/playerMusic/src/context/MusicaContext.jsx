import React from 'react'
import { createContext, useState } from 'react'

//#region Imagem
import goatImg from '../assets/imgs/goat.jpg'
import goatBanner from '../assets/imgs/goat-banner.jpeg'
import pomboImg from '../assets/imgs/erenPombo.jpg'
import pomboBanner from '../assets/imgs/eren-banner.webp'
import spiderVerseImg from '../assets/imgs/spiderverse.png'
import spiderBanner from '../assets/imgs/spiderverse-banner.png'
import valorantImg from '../assets/imgs/valorant.png'
import valorantBanner from '../assets/imgs/kj-lofi-banner.jpeg'
import motoserraImg from '../assets/imgs/chainsaw-man-op.jpg'
import chainsawBanner from '../assets/imgs/chainsaw-man-banner.jpg'
//#endregion Imagens

//#region Audios
import goatAudio from '../assets/audios/polyphia-G.O.A.T.mp3'
import pomboAudio from '../assets/audios/eren-pombo.mp3'
import spiderVerseAudio from '../assets/audios/spider-man-annihilate.mp3'
import valorantAudio from '../assets/audios/safari-riot-vision.mp3'
import motoserraAudio from '../assets/audios/chainsaw-man.mp3'
//#endregion

export const MusicaContext = createContext()

export const MusicaProvider = ({ children }) => {

    const goat = {

        nome: "G.O.A.T",
        artista: "Polyphia",
        capa: goatImg,
        banner: goatBanner,
        musica: goatAudio
    }

    const pombo = {

        nome: "The Rumbling",
        artista: "Eren Pombo",
        capa: pomboImg,
        banner: pomboBanner,
        musica: pomboAudio
    }

    const spiderVerse = {

        nome: "Annihalate",
        artista: "Miranha",
        capa: spiderVerseImg,
        banner: spiderBanner,
        musica: spiderVerseAudio
    }

    const valorant = {

        nome: "Visions",
        artista: "Safari",
        capa: valorantImg,
        banner: valorantBanner,
        musica: valorantAudio
    }

    const motoserra = {

        nome: "Kick Back",
        artista: "Randandan",
        banner: chainsawBanner,
        capa: motoserraImg,
        musica: motoserraAudio
    }

    const [nome, setNome] = useState('')
    const [artista, setArtista] = useState('')
    const [capa, setCapa] = useState('')
    const [musica, setMusica] = useState({})
    const [exist, setExist] = useState(false)

    const musicas = [goat, pombo, spiderVerse, valorant, motoserra]

    return (
        
        <MusicaContext.Provider value={{musica, setMusica, musicas, goat, pombo, spiderVerse, valorant, motoserra, exist, setExist}}>
            {children}
        </MusicaContext.Provider>
    )
}
