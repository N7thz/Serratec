import React from 'react'
import { View, Text } from 'react-native'
import { AntDesign } from '@expo/vector-icons';
import { styles } from './styles';

export const OpcLogin = () => {

    return (

        <View style={styles.btns}>
            <View style={styles.opLogin}>
                <AntDesign name="google" size={18} color="white" />
                <Text style={styles.text}>Continuar com o Google</Text>
            </View>
            
            <View style={styles.opLogin}>
                <AntDesign name="facebook-square" size={18} color="#3a5896" />
                <Text style={styles.text}>Continuar com o Google</Text>
            </View>

            <View style={styles.opLogin}>
                <AntDesign name="apple1" size={18} color="white" />
                <Text style={styles.text}>Continuar com o Google</Text>
            </View>
            
            <View style={styles.opLogin}>
                <Text style={styles.text}>Continuar com um número de telefone </Text>
            </View>
        </View>

    )
}