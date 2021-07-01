package com.ubb.conferencesystem.controller;

import com.ubb.conferencesystem.model.Author;
import com.ubb.conferencesystem.model.Listener;
import com.ubb.conferencesystem.model.User;
import com.ubb.conferencesystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @RequestMapping(path = "/register/{type}")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@PathVariable String type,
                             @RequestBody User user) throws Exception {
        String email = user.getEmail();
        User userFetched = null;
        if (email != null && !email.equals("")) {
            userFetched = service.fetchUserByEmail(email);
            if (userFetched != null) {
                throw new Exception("User with " + email + " already exists!");
            }
        }
        System.out.println(type);
        if (type.equals("author")) {
            Author author = new Author();
            author.setId(user.getId());
            author.setEmail(user.getEmail());
            author.setPassword(user.getPassword());
            author.setUsername(user.getUsername());
            author.setType("author");
            return service.saveUser(author);
        }
        else if (type.equals("listener")) {
            Listener listener = new Listener();
            listener.setId(user.getId());
            listener.setEmail(user.getEmail());
            listener.setPassword(user.getPassword());
            listener.setUsername(user.getUsername());
            listener.setType("listener");
            return service.saveUser(listener);
        }
        return null;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String userName = user.getUsername();
        String password = user.getPassword();
        User userObj = null;
        if (userName != null && password != null) {
            userObj = service.fetchUserByUsernameAndPassword(userName, password);
        }
        if (userObj == null) {
            throw new Exception("Bad credentials!");
        }
        return userObj;
    }

}
