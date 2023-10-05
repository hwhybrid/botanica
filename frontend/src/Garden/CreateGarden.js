import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const API_BASE_URL = 'http://localhost:8080';

function CreateGarden() {
    const navigate = useNavigate();
    const [gardenName, setGardenName] = useState('');

    const handleCreateGarden = async () => {
        try {
            const response = await axios.post(`${API_BASE_URL}/api/v1/gardens`, {
                gardenName,
                // Assign the garden to user1 (hardcoded username)
                userId: 1,
            });
            console.log(response.data);
            // Redirect to the GardenCreationPage after successful creation
            navigate('/create-garden'); // Navigate to the new page
        } catch (error) {
            console.error('Error creating garden:', error);
        }
    };


    return (
        <div>
            <h1>Create a New Garden:</h1>
            <input
                type="text"
                placeholder="Garden Name"
                value={gardenName}
                onChange={(e) => setGardenName(e.target.value)}
            />
            <button onClick={handleCreateGarden}>Create Garden</button>
        </div>
    );
}

export default CreateGarden;
