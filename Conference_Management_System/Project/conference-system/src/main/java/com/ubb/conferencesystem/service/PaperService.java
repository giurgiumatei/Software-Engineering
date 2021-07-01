package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.Paper;
import com.ubb.conferencesystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ubb.conferencesystem.repository.PaperRepository;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperRepository repository;

    public List<Paper> findAll(){
        return this.repository.findAll();
    }

    public Paper savePaper(Paper paper) {
        return repository.save(paper);
    }

    public Paper fetchPaperByTitle(String title) {
        return repository.findByTitle(title);
    }
}
