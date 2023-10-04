import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Garden from './Garden/Garden';
import { Route, Routes } from "react-router-dom";
import NavBar from "./NavBar";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Register from "./Auth/Register";
import Login from "./Auth/Login";
import GardenPage from "./Garden/GardenPage";
import theme from './theme';
import { ThemeProvider } from '@mui/material/styles';
import PlantList from "./Plants/PlantList";
import CreateGarden from "./Garden/CreateGarden";

function App() {
    return (
        <ThemeProvider theme={theme}>
            <div className="App">
                <NavBar />
                <header className="App-header">
                    <h1>Welcome to Botanica</h1>
                    <h3>...your very own virtual garden.</h3>
                </header>
                <main>
                    <Routes>
                        <Route exact path="/" element={<Garden />} />
                        <Route path="/gardens" element={<GardenPage />} />
                        <Route path="/about" element={<About />} />
                        <Route path="/contact" element={<Contact />} />
                        <Route path="/register" element={<Register />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/plants" element={<PlantList />} />
                        <Route path="/create-garden" element={<CreateGarden />} />

                    </Routes>
                </main>
            </div>
        </ThemeProvider>
    );
}

export default App;
