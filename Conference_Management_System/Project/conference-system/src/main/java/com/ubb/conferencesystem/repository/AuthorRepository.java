package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
