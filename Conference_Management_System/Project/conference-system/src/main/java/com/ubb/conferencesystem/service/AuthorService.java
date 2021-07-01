package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.Author;
import com.ubb.conferencesystem.model.User;
import com.ubb.conferencesystem.repository.AuthorRepository;
import com.ubb.conferencesystem.repository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author fetchAuthorById(Long id) {
        return authorRepository.findById(id).orElseGet(null);
    }

}
