package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.services.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/gardens")
public class GardenController {

    @Autowired
    private final GardenService gardenService;

    @Autowired
    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }


    @GetMapping("")
    public ResponseEntity<List<Garden>> getAllGardens() {
        List<Garden> gardens = gardenService.getAllGardens();
        return ResponseEntity.ok(gardens);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Garden>> getUserGardens(@PathVariable Long userId) {
        List<Garden> gardens = gardenService.getUserGardens(userId);
        return ResponseEntity.ok(gardens);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Garden> createGarden(@PathVariable Long userId, @RequestBody GardenDto gardenDto) {
        Garden garden = gardenService.createGarden(userId, gardenDto);
        return ResponseEntity.ok(garden);
    }

    @PutMapping("/{gardenId}")
    public ResponseEntity<Garden> updateGarden(@PathVariable Long gardenId, @RequestBody GardenDto updatedGardenDto) {
        Garden updatedGarden = gardenService.updateGarden(gardenId, updatedGardenDto);
        return ResponseEntity.ok(updatedGarden);
    }

    @DeleteMapping("/{gardenId}")
    public ResponseEntity<Void> deleteGarden(@PathVariable Long gardenId) {
        gardenService.deleteGarden(gardenId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{gardenId}/add-plant")
    public ResponseEntity<Void> addPlantToGarden(@PathVariable Long gardenId, @RequestParam Long plantId) {
        gardenService.addPlantToGarden(gardenId, plantId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{gardenId}/remove-plants")
    public ResponseEntity<Void> removePlantsFromGarden(@PathVariable Long gardenId, @RequestBody List<Long> plantIds) {
        gardenService.removePlantsFromGarden(gardenId, plantIds);
        return ResponseEntity.noContent().build();
    }

}
