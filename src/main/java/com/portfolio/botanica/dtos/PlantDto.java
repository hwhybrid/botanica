package com.portfolio.botanica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantDto {
    private Long plantId;
    private String plantName;
    private String scientificName;
    private String plantDescription;
    private boolean edible;
    private String imageUrl;
}