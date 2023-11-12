import React from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { Entypo } from '@expo/vector-icons';

export const More = () => {

    return (

        <View style={styles.more}>
            <Text style={styles.more.text}>Letra</Text>
            <View style={styles.icons}>
                <AntDesign style={styles.icon} name="sharealt" size={24} color="white" />
                <Entypo style={styles.icon} name="resize-full-screen" size={24} color="white" />
            </View>
        </View>
    )
}