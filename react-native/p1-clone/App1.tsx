import { Text, View } from 'react-native';
import { useFonts } from 'expo-font';
import { styles } from './styles1';
import { OpcLogin } from './src/assets/components/OpcLogin';
import { Inputs } from './src/assets/components/Inputs';
import { Entypo } from '@expo/vector-icons';
import { Button } from './src/assets/components/Button';
import { Info } from './src/assets/components/Info';

export default function App() {

  const [fontsLoaded] = useFonts({
    'spotifyFont': require('./src/assets/fonts/spofify-fonts/Gotham-Medium.ttf')
  })

  return (

    <View style={styles.background}>

      <View style={styles.container}>
        <Text style={[styles.title, { fontFamily: 'spotifyFont' }]}>Entrar no Spotify</Text>
        <OpcLogin />
        <Inputs />
        <Button activeOpacity={.3} onPress={() => {alert('é os guri')}}/>
        <Info />
      </View>
    </View>
  );
}


