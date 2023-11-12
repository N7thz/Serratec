import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({

    footer : {

        width: '100%',
        flex : .5,
        flexDirection : 'row',
        justifyContent : 'space-between',
    },

    container : {

        width : '30%',
        flexDirection : 'row',
        justifyContent : 'space-around',
        alignItems : 'center',
        paddingHorizontal : 20,

        text : {

            fontFamily : 'spotifyFont',
            color : '#1ed75f'
        }
    },
})