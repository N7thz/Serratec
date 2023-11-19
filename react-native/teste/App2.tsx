import React, { useState, useEffect } from 'react'
import { View, Text, StyleSheet, ImageBackground, TouchableOpacity } from 'react-native'

import axios from 'axios'

import Pag404 from './assets/404.jpg'

const App = () => {

  const [exist, setExist] = useState<boolean>(true)
  const [nome, setNome] = useState<string>('')
  const [title, setTitle] = useState<string>('')
  const [lore, setLore] = useState<string>('')
  const [ataque, setAtaque] = useState<string>('')
  const [defesa, setDefesa] = useState<string>('')
  const [magica, setMagica] = useState<string>('')
  const [dificuldade, setDificuldade] = useState<string>('')
  const [image, setImage] = useState<any>()

  const champion = 'Aatrox'
  const indexSkin = 0

  useEffect(() => {
    getPersonagem(champion)
  }, [champion])

  const imageAtual = `https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion}_${indexSkin}.jpg`
  const nextImage = `https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion}_${indexSkin + 1}.jpg`
  const proxtImage = `https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion}_${indexSkin + 2}.jpg`

  const getPersonagem = async (champion: string) => {

    const response = await axios.get(`https://ddragon.leagueoflegends.com/cdn/13.22.1/data/pt_BR/champion/${champion}.json`)

    const championData = response.data.data[champion]

    setNome(championData.id)
    setTitle(championData.title)
    setLore(championData.lore)
    setImage(imageAtual)
    setAtaque(championData.info.attack)
    setDefesa(championData.info.defense)
    setMagica(championData.info.magic)
    setDificuldade(championData.info.difficulty)
  }

  if (exist) {
    return (
      <View style={styles.container}>
        <View style={styles.box}>
          <ImageBackground
            resizeMode="cover"
            borderTopRightRadius={24}
            source={{ uri: image }}
            style={styles.image} />

          <View style={styles.info}>

            <Text style={styles.subtitle}>{title}</Text>
            <Text style={styles.title}>{nome}</Text>
            <Text style={styles.text}>{lore}</Text>

            <View style={styles.stats}>
              <Text style={styles.subtitle}>Status</Text>
              <Text style={styles.statsText}>Ataque: {ataque}</Text>
              <Text style={styles.statsText}>Defesa: {defesa}</Text>
              <Text style={styles.statsText}>magia: {magica}</Text>
              <Text style={styles.statsText}>Dificuldade: {dificuldade}</Text>
            </View>
          </View>
        </View>

        <View style={styles.skins}>
          <ImageBackground
            resizeMode="contain"
            source={{ uri: imageAtual }}
            style={styles.skin}
          />
          <ImageBackground
            resizeMode="contain"
            source={{ uri: nextImage }}
            style={styles.skin}
          />
          <ImageBackground
            resizeMode="contain"
            source={{ uri: proxtImage }}
            style={styles.skin}
          />
        </View>
      </View>
    )
  } else {

    return (

      <ImageBackground source={Pag404} style={styles.container404}>
        <Text style={styles.title404}>Campeão não encontrado</Text>

        <TouchableOpacity style={styles.button}>
          <Text style={styles.subtitle}>Voltar a Home</Text>
        </TouchableOpacity>
      </ImageBackground>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#09111A',
    justifyContent: 'center',
    alignItems: 'center',
  },

  title: {

    color: '#fff',
    fontSize: 24,
    textAlign: 'center',
  },

  subtitle: {
    color: '#fff',
    fontSize: 18,
    textAlign: 'center',
    marginBottom: 7,
  },

  text: {
    color: '#fff',
    fontSize: 12,
    padding: 8,
    paddingTop: 20,
    textAlign: 'justify',
  },

  image: {

    flex: 1,
  },

  info: {

    flex: 1,
  },

  box: {

    width: '90%',
    height: '70%',
    margin: 20,
    flexDirection: 'row',
  },

  skins: {
    flexDirection: 'row',
    gap: 10,
  },

  skin: {
    width: 75,
    height: 100,
  },

  button: {

    backgroundColor: '#7f66cb',
    shadowColor: '#171717',
    shadowOffset: { width: -2, height: 4 },
    shadowOpacity: 0.2,
    shadowRadius: 3,
    width: '50%',
    height: 60,
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 12,
    marginTop: 20,
  },

  container404: {

    flex: 1,
    backgroundColor: '#09111A',
    justifyContent: 'space-around',
    alignItems: 'center',
  },

  title404: {

    color: '#fff',
    fontSize: 32,
    textAlign: 'center',
  },

  stats: {

    padding: 12
  },

  statsText: {

    fontSize: 18,
    color: '#fff'
  }
})

export default App
