package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("")
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantService.getAllPlants();
        return ResponseEntity.ok(plants);
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
}
