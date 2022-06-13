/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octomoon.selfSpring.model;

import com.octomoon.selfSpring.entity.PetEntity;

/**
 *
 * @author vladmir
 */
public class Pet {

    private Long id;
    private String family;
    private String breed;
    private String sex;

    public static Pet toModel(PetEntity entity) {
        Pet model = new Pet();
        model.setId(entity.getId());
        model.setFamily(entity.getFamily());
        model.setBreed(entity.getBreed());
        model.setSex(entity.getSex());
        return model;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
