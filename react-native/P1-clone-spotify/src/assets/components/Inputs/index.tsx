import { Text, View, TextInput } from 'react-native';
import { styles } from './styles';
import { Entypo } from '@expo/vector-icons';

export const Inputs = () => {
    
    return (

        <View style={styles.inputs}>

            <View style={styles.campoInput}>
                <Text style={styles.textInput}>E-mail ou nome de usuário</Text>
                <TextInput style={styles.input} placeholder='E-mail ou nome de usuário' placeholderTextColor={'#666'}></TextInput>
            </View>

            <View style={styles.campoInput}>
                <Text style={styles.textInput}>Senha</Text>
                <TextInput style={styles.input} placeholder='Senha' placeholderTextColor={'#666'}></TextInput>
                <Entypo style={{ position: 'absolute', top: '56%', right: 15 }} name="eye-with-line" size={24} color="#666" />
            </View>
        </View>
    )
}
