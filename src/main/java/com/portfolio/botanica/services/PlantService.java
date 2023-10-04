package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Plant;

import java.util.List;

public interface PlantService {

    List<Plant> getAllPlants();

    Plant createPlant(PlantDto plantDto);

    void loadPlantDataFromJson();

    boolean isDatabaseSeeded();

    void deleteAllPlants();
}
