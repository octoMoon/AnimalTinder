/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octomoon.selfSpring.service;

import com.octomoon.selfSpring.entity.PetEntity;
import com.octomoon.selfSpring.entity.UserEntity;
import com.octomoon.selfSpring.model.Pet;
import com.octomoon.selfSpring.repository.PetRepo;
import com.octomoon.selfSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vladmir
 */
@Service
public class PetService {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private UserRepo userRepo;

    public Pet createPet(PetEntity pet, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        pet.setUser(user);
        return Pet.toModel(petRepo.save(pet));

    }

}
