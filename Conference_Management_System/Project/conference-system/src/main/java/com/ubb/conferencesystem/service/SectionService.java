package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.Section;
import com.ubb.conferencesystem.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }
}
