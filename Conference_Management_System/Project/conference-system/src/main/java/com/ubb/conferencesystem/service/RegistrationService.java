package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.User;
import com.ubb.conferencesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository repository;
    
    public User saveUser(User user) {
        return repository.save(user);
    }

    public User fetchUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User fetchUserByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    public String findTypeByUsername(String username) {
        return repository.findByUsername(username).getType();
    }
}
