package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;

import java.util.List;

public interface GardenService {

    List<Garden> getUserGardens(Long userId);

    Garden createGarden(Long userId, GardenDto gardenDto);

    Garden updateGarden(Long gardenId, GardenDto updatedGardenDto);

    void deleteGarden(Long gardenId);

    void addPlantToGarden(Long gardenId, Long plantId);

    void removePlantsFromGarden(Long gardenId, List<Long> plantIds);


    List<Garden> getAllGardens();
}
