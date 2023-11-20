import { NavigationContainer } from '@react-navigation/native'
import { TabNavigation } from './Tab.routes'
import React from 'react';

export const Routes = () => {

    return <NavigationContainer>
        <TabNavigation />
    </NavigationContainer>
}