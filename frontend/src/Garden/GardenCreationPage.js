import React, { useState } from 'react';
import CreateGarden from './CreateGarden';
import AvailablePlantsList from '../Plants/AvailablePlantsList';

function GardenCreationPage() {
    const [selectedPlants, setSelectedPlants] = useState([]);

    const handlePlantSelect = (plantId) => {
        setSelectedPlants([...selectedPlants, plantId]);
    };

    const handleSubmit = () => {
        // Handle the submission of the garden with selected plants
        // You can send a request to your backend to save the garden with selected plants
        console.log('Selected plants:', selectedPlants);
        // Add your API request logic here
    };

    return (
        <div>
            <h1>Create a New Garden</h1>

            <CreateGarden />

            <AvailablePlantsList onPlantSelect={handlePlantSelect} />

            <div>
                <h2>Selected Plants</h2>
                <ul>
                    {selectedPlants.map((plantId) => (
                        <li key={plantId}>{/* Display selected plant details here */}</li>
                    ))}
                </ul>
            </div>

            <button onClick={handleSubmit}>Submit Garden</button>
        </div>
    );
}

export default GardenCreationPage;
