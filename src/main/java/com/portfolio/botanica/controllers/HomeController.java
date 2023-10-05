package com.portfolio.botanica.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*") // Allows requests from the frontend
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "Hello, welcome home!";
    }

    @GetMapping("/secured")
    public String secured() {

        return "Hello, secured!";
    }


}
