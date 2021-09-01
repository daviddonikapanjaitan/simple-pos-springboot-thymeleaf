package com.simple.pos.simplepointofsale.service;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;
import com.simple.pos.simplepointofsale.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    User findByEmail(String email);
    
    User save(UserRegistrationDto registrationDto);
}
