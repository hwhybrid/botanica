package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.entities.Plant;

import java.util.List;

public interface GardenService {

    List<Garden> getUserGardens(Long userId);

    Garden createGarden(Long userId, GardenDto gardenDto);

    void deleteGarden(Long gardenId);

    Garden findGardenOrThrow(Long gardenId);

    Garden updateGarden(Long gardenId, GardenDto updatedGardenDto);

    void addPlantToGarden(Long gardenId, Long plantId);

    void removePlantsFromGarden(Long gardenId, List<Long> plantIds);

    List<Plant> getPlantsInGarden(Long gardenId);

    List<Garden> getAllGardens();
}
