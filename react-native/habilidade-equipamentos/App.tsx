import { View, Text, Image, TouchableOpacity, TextInput } from 'react-native';
import { styles } from './styles';
import { useEffect, useState } from 'react';
import img from './assets/img/guri.jpg'

const App = () => {

  const [greeting, setGreetings] = useState<String>('')
  const [skill, setSkill] = useState('')
  const [newSkill, setNewSkill] = useState('')

  useEffect(() => {

    const currentHour = new Date().getHours();

    if (currentHour < 12) {

      setGreetings('GoodMorning')
    } else if (currentHour >= 12 && currentHour < 18) {

      setGreetings('Good Afternoon')
    } else {

      setGreetings('Good Evening')
    }
  }, [])

  return (

    <View style={styles.container}>
      <Text style={styles.title}>é os guri n tem jeito</Text>
      <Text style={styles.greetings}>
        {greeting}
      </Text>

      <TextInput
        style={styles.input}
        onChangeText={setNewSkill}
        placeholder="useless placeholder"
        keyboardType="numeric"
      />

      <TouchableOpacity style={styles.button} >
        <Text  style={styles.buttonText}>
          add new Skill
        </Text>
      </TouchableOpacity>

      <TouchableOpacity activeOpacity={0.3}>
        <Image style={styles.image} source={img} />
      </TouchableOpacity>

      <View>
        <Text style={styles.title}>skill 1</Text>
        <Image style={styles.image} source={img}/>
      </View>

      <View>
        <Text style={styles.title}>skill 2</Text>
        <Image style={styles.image} source={img}/>
      </View>

      <View>
        <Text style={styles.title}>skill 3</Text>
        <Image style={styles.image} source={img}/>
      </View>

    </View>
  );
}

export default App
