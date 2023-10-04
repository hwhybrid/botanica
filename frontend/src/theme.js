import { createTheme } from '@mui/material/styles';

// Defines the custom color palette
const theme = createTheme({
    palette: {
        primary: {
            main: '#8E6C88', // Lavender Gray
        },
        secondary: {
            main: '#A8DADC', // Turquoise Blue
        },
        background: {
            default: '#FFE5D9', // Peachy Pink
        },
        text: {
            primary: '#1D3557', // Navy Blue
        },
        accent: {
            main: '#F4A261', // Caramel
        },
    },
    typography: {
        fontFamily: 'Comfortaa, sans-serif',
    },
});

export default theme;
