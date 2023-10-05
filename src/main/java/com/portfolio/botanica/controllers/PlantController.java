package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.services.GardenService;
import com.portfolio.botanica.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plants")
@CrossOrigin // Allows requests from the frontend

public class PlantController {
    private final PlantService plantService;

    @Autowired
    public GardenService gardenService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("")
    public ResponseEntity<List<Plant>> getAllPlants() {
//    public ResponseEntity<List<Garden>> getAllPlants() {

        List<Plant> plants = plantService.getAllPlants();
//        List<Garden> gardens = gardenService.getAllGardens();

        return ResponseEntity.ok(plants);
//        return ResponseEntity.ok(gardens);

    }

    @PostMapping("/create")
    public ResponseEntity<Plant> createPlant(@RequestBody PlantDto plantDto) {
        Plant plant = plantService.createPlant(plantDto);
        return ResponseEntity.ok(plant);
    }

    @PostMapping("/load")
    public void loadPlantData() {
        plantService.loadPlantDataFromJson();
    }


    @GetMapping("/all")
    public ResponseEntity<List<Garden>> getAllGardens() {
        List<Garden> gardens = gardenService.getAllGardens();
        return ResponseEntity.ok(gardens);
    }
}
