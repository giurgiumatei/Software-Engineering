package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Author;
import com.ubb.conferencesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmail(String email);
    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);
}
