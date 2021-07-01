package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.Conference;
import com.ubb.conferencesystem.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    ConferenceRepository repository;

    public List<Conference> findAll(){
        return this.repository.findAll();
    }

    public Conference findById(Long id){
        return this.repository.getById(id);
    }

    @Transactional
    public void updateConference(Conference conference){
        if(!repository.existsById(conference.getId())){
            throw new RuntimeException("Conference doesn't exist");
        }

        this.repository.findById(conference.getId()).ifPresent(
                e -> {
                    e.setEndDate(conference.getEndDate());
                    e.setStartDate(conference.getStartDate());
                    e.setName(conference.getName());
                }
        );
    }
}
