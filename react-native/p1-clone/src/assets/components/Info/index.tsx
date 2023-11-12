import React from 'react'
import { View, Text } from 'react-native'
import { styles } from './styles'

export const Info = () => {

    return (

        <View style={styles.info}>
            <Text style={styles.text}>Esqueceu sua senha</Text>
            <Text style={[styles.text, {textDecorationLine : 'none', color : '#e3dfdf'}]}>Não tem uma conta?</Text>
            <Text style={styles.text}>Increver-se no Spotify</Text> 
        </View>
    )
}
