package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    public Paper findByTitle(String title);
}
