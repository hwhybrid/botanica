package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.UserDto;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
