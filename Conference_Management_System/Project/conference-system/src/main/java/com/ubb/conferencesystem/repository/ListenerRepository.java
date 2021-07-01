package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<Listener, Long> {
}
