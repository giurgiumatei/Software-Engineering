package com.ubb.conferencesystem.repository;

import com.ubb.conferencesystem.model.PCMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCMemberRepository extends JpaRepository<PCMember, Long> {
}
