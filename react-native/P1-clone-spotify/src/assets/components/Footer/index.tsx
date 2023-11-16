import React from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { MaterialIcons } from '@expo/vector-icons';
import { FontAwesome } from '@expo/vector-icons';

export const Footer = () => {

    return (

        <View style={styles.footer}>
            <View style={styles.container}>
                <MaterialIcons name="computer" size={24} color="#1ed75f" />
                <Text style={styles.container.text}>PC</Text>
            </View>
            <View style={styles.container}>
                <AntDesign name="sharealt" size={24} color="white" />
                <FontAwesome name="bars" size={24} color="white" />
            </View>
        </View>
    )
}