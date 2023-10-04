package com.portfolio.botanica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantedPlantDto {
    private Long plantedPlantId;
    private Long gardenId;
    private Long plantId;



}
