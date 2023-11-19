import { createStackNavigator } from '@react-navigation/stack'

import { Perfil } from '../screens/perfil'

const Stack = createStackNavigator()

export default function StackRoutes() {

    return (

        <Stack.Navigator screenOptions={{ headerShown: false}}>
            <Stack.Screen 
                name='perfil'
                component={Perfil}
            />
        </Stack.Navigator>
    )
} 

