/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.octomoon.selfSpring.repository;

import com.octomoon.selfSpring.entity.PetEntity;
import com.octomoon.selfSpring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vladmir
 */
public interface PetRepo
extends CrudRepository<PetEntity, Long>{
    
}
