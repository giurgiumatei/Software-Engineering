package com.ubb.conferencesystem.controller;

import com.ubb.conferencesystem.model.Conference;
import com.ubb.conferencesystem.service.ConferenceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/chair")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Conference> getAllConferences(){
        return conferenceService.findAll();
    }

    @RequestMapping(value = "/chair/updateConference/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateConference(@PathVariable Long id ,@RequestBody Conference conference){
        try{
            conference.setId(id);
            this.conferenceService.updateConference(conference);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
