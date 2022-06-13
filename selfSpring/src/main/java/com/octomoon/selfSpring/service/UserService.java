/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.octomoon.selfSpring.service;

import com.octomoon.selfSpring.entity.UserEntity;
import com.octomoon.selfSpring.exceptions.MailNotFoundException;
import com.octomoon.selfSpring.exceptions.UserAlreadyExistException;
import com.octomoon.selfSpring.exceptions.UserNotFoundException;
import com.octomoon.selfSpring.model.User;
import com.octomoon.selfSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author vladmir
 */
@Service
public class UserService {

    @Autowired
    private static JavaMailSender javaMailSender;

    @Autowired
    private UserRepo userRepo;

   public void sendEmail(String mail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);
        msg.setSubject("Потверждение");
        msg.setText("Потвердите адресс электронной почты");

        javaMailSender.send(msg);

    }

    public UserEntity registartion(UserEntity user) throws UserAlreadyExistException, MailNotFoundException {
        if (userRepo.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }

        if (!user.getMail().contains(".") || !user.getMail().contains("@") || user.getMail().contains(" ")) {
            throw new MailNotFoundException("Введите реальный адресс электронной почты");
        }

        if (userRepo.findByMail(user.getMail()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким адрессом уже существует!");

        }

        //sendEmail(user.getMail());
        return userRepo.save(user);

    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (userRepo.findById(id).get() == null) {
            throw new UserNotFoundException("Пользователь с таким id, не найден!");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
