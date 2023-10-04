package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.entities.PlantedPlant;
import com.portfolio.botanica.entities.User;
import com.portfolio.botanica.repositories.GardenRepository;
import com.portfolio.botanica.repositories.PlantedPlantRepository;
import com.portfolio.botanica.repositories.UserRepository;
import com.portfolio.botanica.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {
    @Autowired
    private GardenRepository gardenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantedPlantRepository plantedPlantRepository;


    @Override
    @Transactional
    public List<Garden> getUserGardens(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Use the GardenRepository to find gardens associated with the user.
            return gardenRepository.findByUser(user);
        }

        throw new IllegalArgumentException("User not found");
    }

//    @Override
//    @Transactional
//    public Garden createGarden(Long userId, GardenDto gardenDto) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            Garden garden = new Garden();
//            garden.setGardenName(gardenDto.getGardenName());
//            garden.setUser(user);
//
//            // Save the garden to the database
//            garden = gardenRepository.save(garden);
//
//            return garden;
//        }
//
//        throw new IllegalArgumentException("User not found");
//    }

    @Override
    @Transactional
    public Garden createGarden(Long userId, GardenDto gardenDto) {
        if (userId == null) {
            // Using a default id value in an attempt to circumvent CORS issue.
            userId = 1L; // Replaces DEFAULT_USER_ID with the ID of default user
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Garden garden = new Garden();
            garden.setGardenName(gardenDto.getGardenName());
            garden.setUser(user);

            // Save the garden to the database
            garden = gardenRepository.save(garden);

            return garden;
        }

        throw new IllegalArgumentException("User not found");
    }


    @Override
    @Transactional
    public Garden findGardenOrThrow(Long gardenId) {
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        if (gardenOptional.isPresent()) {
            return gardenOptional.get();
        }
        throw new IllegalArgumentException("Garden not found");
    }

    private List<Plant> getPlantsFromDto(List<Long> plantIds) {
        if (plantIds != null && !plantIds.isEmpty()) {
            return plantRepository.findAllById(plantIds);
        }
        return new ArrayList<>();
    }


    @Override
    @Transactional
    public void deleteGarden(Long gardenId) {

        if (gardenRepository.existsById(gardenId)) {

            gardenRepository.deleteById(gardenId);
        } else {
            throw new IllegalArgumentException("Garden not found");
        }
    }

    @Override
    @Transactional
    public Garden updateGarden(Long gardenId, GardenDto updatedGardenDto) {
        Garden garden = findGardenOrThrow(gardenId);

        // Updates garden properties
        garden.setGardenName(updatedGardenDto.getGardenName());

        return gardenRepository.save(garden);
    }

    @Override
    @Transactional
    public void addPlantToGarden(Long gardenId, Long plantId) {
        Garden garden = findGardenOrThrow(gardenId);
        Optional<Plant> plantOptional = plantRepository.findById(plantId);

        if (plantOptional.isPresent()) {
            Plant plant = plantOptional.get();
            // Creates a new PlantedPlant entity and associate it with the garden and plant
            PlantedPlant plantedPlant = new PlantedPlant();
            plantedPlant.setGarden(garden);
            plantedPlant.setPlant(plant);

            // Saves the PlantedPlant entity
            plantedPlantRepository.save(plantedPlant);
        } else {
            throw new IllegalArgumentException("Plant not found");
        }
    }

    @Override
    @Transactional
    public void removePlantsFromGarden(Long gardenId, List<Long> plantIds) {
        Garden garden = findGardenOrThrow(gardenId);

        for (Long plantId : plantIds) {
            Optional<PlantedPlant> plantedPlantOptional = plantedPlantRepository.findById(plantId);
            if (plantedPlantOptional.isPresent()) {
                PlantedPlant plantedPlant = plantedPlantOptional.get();
                // Removes the PlantedPlant entity from the planted_plants table
                plantedPlantRepository.delete(plantedPlant);
            }
        }

        gardenRepository.save(garden);
    }


    @Override
    @Transactional
    public List<Plant> getPlantsInGarden(Long gardenId) {
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        if (gardenOptional.isPresent()) {
            List<PlantedPlant> plantedPlants = plantedPlantRepository.findByGarden_GardenId(gardenId);
            List<Plant> plantsInGarden = new ArrayList<>();
            for (PlantedPlant plantedPlant : plantedPlants) {
                plantsInGarden.add(plantedPlant.getPlant());
            }
            return plantsInGarden;
        }
        throw new IllegalArgumentException("Garden not found");
    }

    @Override
    @Transactional
    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

}
