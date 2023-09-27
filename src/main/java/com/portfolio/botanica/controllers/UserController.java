package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.UserDto;
import com.portfolio.botanica.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<List<String>> registerUser(@RequestBody UserDto userDto) {
        List<String> response = userService.addUser(userDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<List<String>> userLogin(@RequestBody UserDto userDto) {
        List<String> response = userService.userLogin(userDto);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }
//    // Add registration and other endpoints...
}
