package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.entities.User;
import com.portfolio.botanica.repositories.GardenRepository;
import com.portfolio.botanica.repositories.UserRepository;
import com.portfolio.botanica.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Garden createGarden(Long userId, GardenDto gardenDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Garden garden = new Garden();
            garden.setGardenName(gardenDto.getGardenName());
            garden.setUser(user);

            return gardenRepository.save(garden);

        }

        throw new IllegalArgumentException("User not found");
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
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        if (gardenOptional.isPresent()) {
            Garden garden = gardenOptional.get();
            garden.setGardenName(updatedGardenDto.getGardenName());
            return gardenRepository.save(garden);
        }

        throw new IllegalArgumentException("Garden not found");
    }

    @Override
    @Transactional
    public void addPlantToGarden(Long gardenId, Long plantId) {
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        Optional<Plant> plantOptional = plantRepository.findById(plantId);

        if (gardenOptional.isPresent() && plantOptional.isPresent()) {
            Garden garden = gardenOptional.get();
            Plant plant = plantOptional.get();

            // Check if the plant is not already in the garden to avoid duplicates
            if (!garden.getAssociatedPlants().contains(plant)) {
                garden.getAssociatedPlants().add(plant);
                gardenRepository.save(garden);
            }
        } else {
            throw new IllegalArgumentException("Garden or Plant not found");
        }
    }


    @Override
    @Transactional
    public void removePlantsFromGarden(Long gardenId, List<Long> plantIds) {
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        if (gardenOptional.isPresent()) {
            Garden garden = gardenOptional.get();

            for (Long plantId : plantIds) {
                Optional<Plant> plantOptional = plantRepository.findById(plantId);
                if (plantOptional.isPresent()) {
                    Plant plant = plantOptional.get();
                    if (garden.getAssociatedPlants().contains(plant)) {
                        garden.getAssociatedPlants().remove(plant);
                        gardenRepository.save(garden);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Garden not found");
        }
    }


    @Override
    public List<Garden> getAllGardens() {
        return null;
    }

}
