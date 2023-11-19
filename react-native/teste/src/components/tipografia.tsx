import React from 'react'

import { useFonts } from 'expo-font';

const tipografia = () => {

    const [fontsLoaded] = useFonts({

        'fontRegular': require('./BeaufortforLOL-Bold.ttf'),
    });
}

export default tipografia
