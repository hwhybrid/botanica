package com.portfolio.botanica.dtos;


import com.portfolio.botanica.entities.Garden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GardenDto implements Serializable {
    private Long gardenId;
    private String gardenName;
    private UserDto userDto;

    public GardenDto(Garden garden){
        if (garden.getGardenId() != null){
            this.gardenId = garden.getGardenId();
        }
        if (garden.getGardenName() != null){
            this.gardenName = garden.getGardenName();
        }
    }
}
