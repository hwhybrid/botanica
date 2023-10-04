import React, { useEffect, useState } from 'react';

import { getAllPlants } from "../api";

const Garden = () => {
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        // Fetches plants from the backend when the component mounts
        getAllPlants()
            .then((response) => {
                setPlants(response.data);
            })
            .catch((error) => {
                console.error('Error fetching plants:', error);
            });
    }, []);

    return (
        <div>
            {/*<h1>Welcome to your Virtual Garden!</h1>*/}
            {/*<ul>*/}
            {/*    {plants.map((plant) => (*/}
            {/*        <li key={plant.plantId}>{plant.plantName}</li>*/}
            {/*    ))}*/}
            {/*</ul>*/}
        </div>
    );
};

export default Garden;



