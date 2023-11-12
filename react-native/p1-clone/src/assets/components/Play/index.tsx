import React, { useEffect } from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { FontAwesome } from '@expo/vector-icons';
import audio from '../../audios/BillieEilish_myBoy.mp3'
import Sound from 'react-native-sound';

export const Play = () => {

    return (

        <View style={styles.play}>
            <FontAwesome name="random" size={32} color="white" />
            <AntDesign name="stepbackward" size={32} color="white" />
            <AntDesign name="play" size={72} color="white" />
            <AntDesign name="stepforward" size={32} color="white" />
            <FontAwesome name="repeat" size={32} color="#1ed75f" />
        </View>
    )
}