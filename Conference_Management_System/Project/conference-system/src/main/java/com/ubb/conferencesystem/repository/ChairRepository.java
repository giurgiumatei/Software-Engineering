package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChairRepository extends JpaRepository<Chair, Long> {
}
