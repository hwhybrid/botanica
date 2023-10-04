package com.portfolio.botanica.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.repositories.PlantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Override
    @Transactional
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    @Transactional
    public Plant createPlant(PlantDto plantDto) {
        Plant plant = new Plant();
        plant.setPlantName(plantDto.getPlantName());
        plant.setScientificName(plantDto.getScientificName());
        plant.setPlantDescription(plantDto.getPlantDescription());
        plant.setEdible(plantDto.isEdible());
        plant.setImageUrl(plantDto.getImageUrl());

        return plantRepository.save(plant);

    }

    @Transactional
    public void loadPlantDataFromJson() {
        try {
            // Load the JSON file from the classpath
            Resource resource = new ClassPathResource("data/plants.json");
            InputStream inputStream = resource.getInputStream();

            // Parse the JSON data into an array of Plant objects
            ObjectMapper objectMapper = new ObjectMapper();
            Plant[] plants = objectMapper.readValue(inputStream, Plant[].class);

            // Save the parsed data into the database using your repository
            plantRepository.saveAll(Arrays.asList(plants));
        } catch (IOException e) {
            // Handle exceptions if the file is not found or cannot be loaded.
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDatabaseSeeded() {
        // Checks if there are any existing records in the plant table
        return plantRepository.count() > 0;
    }

    @Override
    public void deleteAllPlants() {
        plantRepository.deleteAll();
    }
}
