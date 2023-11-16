import React, { useEffect, useState } from 'react'
import { Text, View, Button } from 'react-native';
import { styles } from './styles';
import { Audio } from 'expo-av';

import { AntDesign } from '@expo/vector-icons';
import { FontAwesome } from '@expo/vector-icons';

export const Play = () => {

    const [sound, setSound] = useState<Audio.Sound | undefined>(undefined);
    const [playing, setPlaying] = useState(false)

    useEffect(() => {
        
        const loadSound = async () => {
            const { sound } = await Audio.Sound.createAsync(
                require('../../audios/BillieEilish_myBoy.mp3')
            );
            setSound(sound);
        };

        loadSound();

        return () => {

            if (sound) {
                sound.unloadAsync();
            }
        };
    }, []);

    const playSound = async () => {

        !playing ? sound?.playAsync() : sound?.pauseAsync()

        setPlaying(!playing)
    };

    return (

        <View style={styles.play}>
            <FontAwesome name="random" size={32} color="white" />
            <AntDesign name="stepbackward" size={32} color="white" />

            {
                !playing ?
                    <AntDesign name="play" size={72} color="white" onPress={playSound} /> :
                    <AntDesign name="pausecircle" size={72} color="white" onPress={playSound} />
            }

            <AntDesign name="stepforward" size={32} color="white" />
            <FontAwesome name="repeat" size={32} color="#1ed75f" />
        </View>
    )
}