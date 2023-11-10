import { StyleSheet } from "react-native";
import { Platform } from "react-native";

export const styles = StyleSheet.create({

    container: {

        flex: 1,
        backgroundColor: '#2f2f2f',
        alignItems: 'center',
        justifyContent: 'center',
    },

    title: {
        color: '#fff',
        fontSize: 24,
        fontWeight: 'bold'
    },
    
    greetings: {
		color: '#fff'
	},

    image: {
        tintColor: "#f00",
        width: 50,
        height: 50
    },

    input: {
        backgroundColor:'#1f1e25',
        color: '#fff',
        fontSize: 18,
        padding: Platform.OS === 'ios' ? 15 : 10,
        marginTop: 30,
        borderRadius: 7
    },

    button: {
        backgroundColor:'#a370f7',
        padding: 15,
        borderRadius: 7,
        alignItems: 'center',
        marginTop: 20
    },
    
    buttonText: {
        color: '#FFF',
        fontSize: 17,
        fontWeight: 'bold'
    },
})