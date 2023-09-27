package com.portfolio.botanica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "plants")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    @Column(nullable = false)
    private String plantName;

    @Column(nullable = false)
    private String scientificName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String plantDescription;

    @Column(nullable = false)
    private Boolean edible;

    @Column(name = "image_url")
    private String imageUrl;

}
