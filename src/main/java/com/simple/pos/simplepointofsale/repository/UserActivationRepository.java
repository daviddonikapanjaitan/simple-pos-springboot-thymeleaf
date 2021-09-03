package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.UserActivation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationRepository extends JpaRepository<UserActivation, Long>{
    
    UserActivation findByEmail(String email);
}
