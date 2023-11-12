import React from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { Feather } from '@expo/vector-icons';

export const Title = () => {

    return (
        
        <View style={styles.title}>
            <View>
                <Text style={styles.text}>My boy </Text>
                <Text style={styles.nome}>Billie Eilish</Text>
            </View>
            <AntDesign name="hearto" size={28} color="white" />
        </View>
    )
}