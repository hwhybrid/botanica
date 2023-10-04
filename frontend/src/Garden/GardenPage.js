import React from 'react';
import GardenList from './GardenList';
import { useNavigate } from 'react-router-dom';

function GardenPage() {
    const navigate = useNavigate();

    const handleCreateGardenClick = () => {
        console.log('Create Garden button clicked');
        // Navigate to the /create-garden route
        navigate('/create-garden');
    };

    return (
        <div>
            <h1>Garden Page</h1>

            {/* Render the "Create Garden" button */}
            <button onClick={handleCreateGardenClick}>
                Create Garden
            </button>

            {/* Render the GardenList component */}
            <GardenList />
        </div>
    );
}

export default GardenPage;
