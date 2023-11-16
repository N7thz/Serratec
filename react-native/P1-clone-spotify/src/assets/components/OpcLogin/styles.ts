import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({

    btns: {

        flex : 2,
        alignItems: 'center',
        justifyContent: 'space-evenly',
        gap : 5
    },

    opLogin: {

        width : '70%',
        height : 60,
        borderColor: '#666',
        borderWidth: 3,
        borderRadius: 32,
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
        
    },

    text: {

        color: '#fff',
        fontSize: 16,
        fontFamily: 'spotifyFont',
        textAlign : 'center'
    },
})