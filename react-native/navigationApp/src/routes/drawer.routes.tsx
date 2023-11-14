import { createDrawerNavigator } from '@react-navigation/drawer'
import { Feather } from '@expo/vector-icons'

import TabRoutes from './tab.routes'
import StackRoutes from './stack.routes'

const Drawer = createDrawerNavigator()

export default function DrawerRoutes() {

    return (

        <Drawer.Navigator screenOptions={{ title: 'teste' }}>
            <Drawer.Screen
                name='home'
                component={TabRoutes}
                options={{

                    drawerIcon: ({ color, size }) => <Feather name='home' size={size} color={color} />,
                    drawerLabel: 'Inicio'
                }}
            />

            <Drawer.Screen
                name='profile'
                component={StackRoutes}
                options={{

                    drawerIcon: ({ color, size }) => <Feather name='user' size={size} color={color} />,
                    drawerLabel: 'meu perfil'
                }}
            />
        </Drawer.Navigator>
    )
}
