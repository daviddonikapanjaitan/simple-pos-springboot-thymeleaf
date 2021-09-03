package com.simple.pos.simplepointofsale.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_activation")
public class UserActivation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emai")
    private String email;

    @Column(name = "activation")
    private String activation;

    @Column(name = "activation_date")
    private String activationDate;

    public UserActivation(){

    }

    public UserActivation(String email, String activation, String activationDate) {
        this.email = email;
        this.activation = activation;
        this.activationDate = activationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    @Override
    public String toString() {
        return "UserActivation [activation=" + activation + ", activationDate=" + activationDate + ", email=" + email
                + ", id=" + id + "]";
    }
}
