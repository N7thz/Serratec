import { View, Image } from 'react-native';
import { styles } from './styles';

import Billie from '../../img/Billie_Eilish.png'

export const Main = () => {
    return (
        <View style={styles.image}>
            <Image style={styles.img} source={Billie} />
        </View>
    )
}
