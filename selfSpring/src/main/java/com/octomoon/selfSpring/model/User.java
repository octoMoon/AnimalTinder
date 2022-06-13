/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octomoon.selfSpring.model;

import com.octomoon.selfSpring.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vladmir
 */
public class User {
    private Long id;
    private String userName;
    private List<Pet> pets;

   
    
    public static User toModel(UserEntity entity){
    User model = new User();
    model.setId(entity.getId());
    model.setUserName(entity.getUserName());
    model.setPets(entity.getPets().stream().map(Pet::toModel).collect(Collectors.toList()));
    return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
     public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
   
}
