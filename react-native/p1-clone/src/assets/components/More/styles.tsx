import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({

    more: {

        width: '80%',
        flex: .5,
        flexDirection: 'row',
        justifyContent: 'space-around',
        marginTop: 20,
        borderTopLeftRadius: 16,
        borderTopRightRadius: 16,
        backgroundColor: '#e32d2c',

        text: {
            
            color: '#fff',
            fontSize: 24,
            fontFamily: 'spotifyFont',
            marginTop: 24,
            marginLeft: 12,
        }
    },

    icons: {

        height: '180%',
        flexDirection: 'row',
        alignItems: 'center',
        gap: 20,
    },

    icon: {

        backgroundColor: '#992821',
        padding: 10,
        borderRadius: 999,
    }
})