package com.simple.pos.simplepointofsale.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;
import com.simple.pos.simplepointofsale.model.Role;
import com.simple.pos.simplepointofsale.model.User;
import com.simple.pos.simplepointofsale.model.UserActivation;
import com.simple.pos.simplepointofsale.repository.UserActivationRepository;
import com.simple.pos.simplepointofsale.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private UserActivationRepository userActivationRepository;
    
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        userActivationRepository.save(new UserActivation(
            registrationDto.getEmail(),
            "false",
            null
        ));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Username: " + username);

        UserActivation userActivation = userActivationRepository.findByEmail(username);
        logger.info(userActivation.toString());

        if(userActivation == null){
            logger.info("ERROR: System Error");
            throw new UsernameNotFoundException("System Error.");
        }
       
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        if(!userActivation.getActivation().equalsIgnoreCase("true")){
            logger.info("ERROR: System Error Email Validation");
            throw new UsernameNotFoundException("System Error.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAsuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAsuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())){
            return false;
        }
        
        return authentication.isAuthenticated();
    }

    @Override
    public boolean checkRole(String role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean hasUserRole = authentication.getAuthorities().stream()
          .anyMatch(r -> r.getAuthority().equals(role));
        
        return hasUserRole;
    }
}
