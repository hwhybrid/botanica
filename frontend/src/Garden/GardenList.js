// src/Garden/GardenList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';


const API_BASE_URL = 'http://localhost:8080'; // Define API base URL !!!


function GardenList() {
    const [gardens, setGardens] = useState([]);

    useEffect(() => {
        // Make a GET request to fetch the user's gardens
        axios.get(`${API_BASE_URL}/api/v1/gardens`)
            .then((response) => {
                setGardens(response.data);
            })
            .catch((error) => {
                console.error('Error fetching gardens:', error);
            });
    }, []);

    return (
        <div>
            <h1>These are the current virtual gardens:</h1>
            <ul>
                {gardens.map((garden) => (
                    <li key={garden.gardenId}>{garden.gardenName}</li>
                ))}
            </ul>
        </div>
    );
}

export default GardenList;
