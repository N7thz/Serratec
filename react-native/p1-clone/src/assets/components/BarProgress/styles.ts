import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({

    barProgress : {
        
        width: '100%',
        flex : .5,
        alignItems : 'center',
        marginTop : 20,
    },

    bar : {

        width : '80%',
        height : 5,    
        borderRadius : 2,
        margin : 10,
        backgroundColor  : '#c7b8b5'
    },

    value : {

        width : '60%',
        height : 5,  
        backgroundColor : '#fff',
        position : 'relative'
    },

    ball : {

        width : 15,
        height : 15,
        borderRadius : 999,
        backgroundColor : '#fff',
        position : 'absolute',
        top : -5,
        right : 0,
    },

    min : {

        width : '80%',
        flexDirection : 'row',
        justifyContent : 'space-between',

        text : {
            
            color : '#bda9a8'
        }
    }
})