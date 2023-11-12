import React from 'react'
import { View, Text, TouchableOpacity, TouchableOpacityProps } from 'react-native'
import { styles } from './styles'

interface ButtonProps extends TouchableOpacityProps { }

export const Button = ({ ...rest }: ButtonProps) => {

    return (

        <TouchableOpacity {...rest} style={styles.button}>
            <Text style={styles.text}>Entrar</Text>
        </TouchableOpacity>
    )
} 