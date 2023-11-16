import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({

    text: {

        color: '#fff',
        fontSize: 14,
        fontFamily: 'spotifyLight',
    },

    nome: {

        color: '#fff',
        fontSize: 14,
        fontFamily: 'spotifyFont',
        padding: 1
    },

    center: {

        justifyContent: 'center',
        alignItems: 'center',
    },

    header: {

        flex: .5,
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
        width: '100%',
        marginTop: 45,
    },
})