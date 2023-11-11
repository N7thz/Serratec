
import * as React from 'react';
import { StyleSheet, Text, View, TextInput, TouchableOpacity } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';
import { AntDesign } from '@expo/vector-icons';


export default function App() {

  return (

    <>
      <View style={styles.container}>
        <LinearGradient

          colors={['#1f60ee', '#673cf4', '#bd86e4']}
          style={styles.background}>

          <View style={styles.quadro}>
            <Text style={styles.title}>
              Adicione um sonho
            </Text>
            <TextInput placeholder='Digite um título' style={styles.input} />
            <Text style={styles.text}>
              Descrição :
            </Text>
            <TextInput placeholder='Digite seu sonho' style={styles.sonho}/>
            {/* <AntDesign name="staro" size={24} color="white" /> */}
          </View>
        </LinearGradient>
      </View>
    </>
  );
}

const styles = StyleSheet.create({

  container : {

    flex : 2,
    alignItems : 'center'
  },

  background : {
    
    flex : 2,
    width : '100%',
    height : '100%',
    alignItems : 'center',
    justifyContent : 'center'
  },

  quadro : {

    width : '90%',
    height : '50%'
  },

  title : {

    flex : 2,
    fontSize : 32,
    color : '#fff'
  },

  input : {

    flex : 1,
    justifyContent : 'center',
    width : '100%',
    backgroundColor : '#ffffff21',
    borderBottomColor : '#0c79af',
    borderRadius : 4,
    padding : 4
  },

  text : {

    flex : 2,
    fontSize : 28,
    color : '#fff',
    marginTop : 20,
    marginBottom : -60
  },

  sonho : {

    flex : 3,
    width : '100%',
    height : '30%',
    backgroundColor : '#ffffff21',
    borderBottomColor : '#0c79af',
    borderRadius : 4,
    padding : 4,
    marginVertical : 12
  }
});
