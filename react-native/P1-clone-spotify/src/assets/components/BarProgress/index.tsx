import React from 'react'
import { Text, View } from 'react-native';
import { styles } from './styles';

import { AntDesign } from '@expo/vector-icons';
import { Feather } from '@expo/vector-icons';

export const BarProgress = () => {

    return (

        <View style={styles.barProgress}>
            <View style={styles.bar}>
                <View style={styles.value}>
                    <View style={styles.ball}></View>
                </View>
            </View>

            <View style={styles.min}>
                <Text style={styles.min.text}>1:25</Text>
                <Text style={styles.min.text}>3:49</Text>
            </View>
        </View>
    )
}