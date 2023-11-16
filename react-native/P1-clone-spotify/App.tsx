import { styles } from './styles';

import { useFonts } from 'expo-font';
import { LinearGradient } from 'expo-linear-gradient';

import { Header } from './src/assets/components/Header';
import { Main } from './src/assets/components/Main';
import { Title } from './src/assets/components/Title';
import { BarProgress } from './src/assets/components/BarProgress';
import { Play } from './src/assets/components/Play';
import { Footer } from './src/assets/components/Footer';
import { More } from './src/assets/components/More';

export default function App() {

    const [fontsLoaded] = useFonts({

        'spotifyFont': require('./src/assets/fonts/spofify-fonts/Gotham-Medium.ttf'),

        'spotifyLight': require('./src/assets/fonts/spofify-fonts/Gotham-Light.otf')
    })

    return (

        <LinearGradient colors={['#cc2c2c', '#161211']} style={styles.background}>
            <Header />
            <Main />
            <Title />
            <BarProgress />
            <Play />
            <Footer />
            <More />
        </LinearGradient>
    )
}