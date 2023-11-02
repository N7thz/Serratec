import { createContext, useState } from "react";

export const ThemeContext = createContext()

export const ThemeProvider = ({ children }) => {

    const [theme, setTheme] = useState("light")

    const toggleTheme = () => {

        setTheme(theme === "lihgt" ? "dark" : "light")
    }

    return (

        <ThemeContext.Provider value={{theme, toggleTheme}}>
            {children}
        </ThemeContext.Provider>
    )
}