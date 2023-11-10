
import * as React from 'react';
import { StyleSheet, Text, View, Dimensions, TextInput } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';


export default function App() {

  return (

    <>
      <View style={styles.container}>
        <LinearGradient
          colors={['#4c669f', '#094de1', '#620e96']}
          style={styles.background}>

          <View style={styles.quadro}>
            <Text style={styles.title}>
              Adicione um sonho
            </Text>
            <TextInput placeholder='Digite um título' style={styles.input} />
            <Text style={styles.text}>
              Descrição:
            </Text>
          </View>

        </LinearGradient>
      </View>
    </>
  );
}

const styles = StyleSheet.create({

  container: {

    backgroundColor: 'red',
    flex: 1,
    alignItems: 'center',
    justifyContent: 'space-around'
  },

  quadro : {

    backgroundColor : 'red',
    width : '90%',
    height : '30%'
  },

  text: {

    color: '#fff'
  },

  background: {

    width: '100%',
    height: '100%',
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },

  title: {

    fontSize: 36,
    color: '#fff'
  },

  input: {

    width: '80%',
    backgroundColor: '#ffffff21',
    borderBottomColor: '#0c79af',
    borderRadius: 4,
    padding: 4
  }
});
