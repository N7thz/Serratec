import { createDrawerNavigator } from '@react-navigation/drawer'
import { Feather } from '@expo/vector-icons'
import { Entypo } from '@expo/vector-icons';

import TabRoutes from './tab.routes'
import { Login } from '../screens/Login';
import { Home } from '../screens/Home';
import StackRoutes from './stack.routes';

const Drawer = createDrawerNavigator()

export default function DrawerRoutes() {

    return (

        <Drawer.Navigator screenOptions={{ title: '' }}>
            <Drawer.Screen 
                name='Começo'
                component={TabRoutes}
                options={{
                    drawerIcon: ({size, color}) => <Feather name='user' color={color} size={size}/>,
                    drawerLabel: 'Inicio'
                }}
            />
            <Drawer.Screen 
                name='loginDrawer'
                component={Login}
                options={{
                    drawerIcon: ({size, color}) => <Entypo name='login' color={color} size={size}/>,
                    drawerLabel: 'Login'
                }}
            />
            <Drawer.Screen 
                name='homeDrawer'
                component={Home}
                options={{
                    drawerIcon: ({size, color}) => <Entypo name='home' color={color} size={size}/>,
                    drawerLabel: 'Home'
                }}
            />
            <Drawer.Screen 
                name='profile'
                component={StackRoutes}
                options={{
                    drawerIcon: ({size, color}) => <Entypo name='user' color={color} size={size}/>,
                    drawerLabel: 'Perfil'
                }}
            />
        </Drawer.Navigator>
    )
}

