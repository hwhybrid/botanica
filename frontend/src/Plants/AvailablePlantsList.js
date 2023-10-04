// Create a new component to display the list of available plants
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AvailablePlantsList = ({ onPlantSelect }) => {
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        // Fetch the list of available plants from the backend
        axios.get('http://localhost:8080/api/v1/plants')
            .then((response) => {
                setPlants(response.data);
            })
            .catch((error) => {
                console.error('Error fetching available plants:', error);
            });
    }, []);

    const handlePlantSelect = (plantId) => {
        // Callback to handle plant selection
        onPlantSelect(plantId);
    };

    return (
        <div>
            <h2>Available Plants</h2>
            <ul>
                {plants.map((plant) => (
                    <li key={plant.id}>
                        {plant.name}
                        <button onClick={() => handlePlantSelect(plant.id)}>Select</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default AvailablePlantsList;
