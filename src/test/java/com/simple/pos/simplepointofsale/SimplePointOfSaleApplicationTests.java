package com.simple.pos.simplepointofsale;

import com.simple.pos.simplepointofsale.model.UserActivation;
import com.simple.pos.simplepointofsale.repository.UserActivationRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimplePointOfSaleApplicationTests {

	@Autowired
    private UserActivationRepository userActivationRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getUserActivation(){
		UserActivation userActivation = userActivationRepository.findByEmail("daviddonikapanjaitan123@gmail.com");
		if(userActivation != null){
			Assertions.fail();
		}
	}
}
