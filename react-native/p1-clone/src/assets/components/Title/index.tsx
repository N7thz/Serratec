import React, { useState } from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';

export const Title = () => {

    const [liked, setLiked] = useState(false)

    return (

        <View style={styles.title}>
            <View>
                <Text style={styles.text}>My boy </Text>
                <Text style={styles.nome}>Billie Eilish</Text>
            </View>

            {
                !liked ?
                    <AntDesign name="hearto" size={28} color="white" onPress={() => {setLiked(!liked)}} /> :
                    <AntDesign name="heart" size={28} color="#1ed75f"  onPress={() => {setLiked(!liked)}}/>
            }
        </View>
    )
}