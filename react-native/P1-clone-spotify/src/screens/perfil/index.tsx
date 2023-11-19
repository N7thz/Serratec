import { styles } from './styles';

import { LinearGradient } from 'expo-linear-gradient';
import { Text } from 'react-native'


export const Perfil = () => {

    return (

        <LinearGradient colors={['#0467ca', '#2c0347']} style={styles.background}>
            <Text style={styles.text}>é os guri desconheço um jeito</Text>
        </LinearGradient>
    )
}