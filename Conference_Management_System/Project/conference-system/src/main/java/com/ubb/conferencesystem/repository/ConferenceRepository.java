package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
