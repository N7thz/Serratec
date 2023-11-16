import React from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { Feather } from '@expo/vector-icons';

export const Header = () => {
    return (

        <View style={styles.header}>
            <AntDesign name="down" size={24} color="white" />
            <View style={styles.center}>
                <Text style={styles.text}>TOCANDO DA PLAYLIST</Text>
                <Text style={styles.nome}>Billie</Text>
            </View>
            <Feather name="more-vertical" size={24} color="white" />
        </View>
    )
}
