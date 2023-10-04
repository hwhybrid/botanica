import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Carousel } from 'react-bootstrap';


const API_BASE_URL = 'http://localhost:8080'; // Define API base URL first!!

function PlantList() {
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        // Make a GET request to fetch all plants
        axios.get(`${API_BASE_URL}/api/v1/plants`) // Use API_BASE_URL here
            .then((response) => {
                console.log('Plant data response:', response.data);
                setPlants(response.data);
            })
            .catch((error) => {
                console.error('Error fetching plants:', error);
            });
    }, []);

    return (
        <div>
            <h1>These are the plant options for your virtual garden:</h1>
            <Carousel>
                {plants.map((plant) => (
                    <Carousel.Item key={plant.plantId}>
                        {/*<img src={`${process.env.PUBLIC_URL}/plant_images/${plant.imageUrl}`} className="d-block w-100" alt="Plant" />*/}

                        <img
                            src={`${plant.imageUrl}`}
                            className="d-block w-100"
                            alt={plant.plantName}
                        />
                        <Carousel.Caption>
                            <h3>{plant.plantName}</h3>
                            <p>Scientific Name: {plant.scientificName}</p>

                            <p>{plant.plantDescription}</p> {/* Uses the plant description from the fetched data */}
                        </Carousel.Caption>
                    </Carousel.Item>
                ))}
            </Carousel>
        </div>
    );
}

export default PlantList;
