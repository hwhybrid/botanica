package com.portfolio.botanica.dtos;

import com.portfolio.botanica.entities.Garden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GardenDto implements Serializable {
    private Long gardenId;
    private String gardenName;
    private Long userId; // Add the userId property

    private List<Long> plantIds;

    public GardenDto(Garden garden) {
        if (garden.getGardenId() != null) {
            this.gardenId = garden.getGardenId();
        }
        if (garden.getGardenName() != null) {
            this.gardenName = garden.getGardenName();
        }
        // Set the userId property based on the user associated with the garden
        if (garden.getUser() != null) {
            this.userId = garden.getUser().getUserId();
        }
    }
}
