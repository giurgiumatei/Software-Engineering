package com.ubb.conferencesystem.controller;

import com.ubb.conferencesystem.dtos.ChairInvitationDto;
import com.ubb.conferencesystem.model.Email;
import com.ubb.conferencesystem.model.Section;
import com.ubb.conferencesystem.service.ChairService;
import com.ubb.conferencesystem.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChairController {

    @Autowired
    private ChairService chairService;

    @Autowired
    private SectionService sectionService;

    @PostMapping("/chair/invite")
    @CrossOrigin(origins = "http://localhost:4200")
    public void inviteNewMember(@RequestBody ChairInvitationDto chairInvitationDto) {
        System.out.println(chairInvitationDto);
        Email email = new Email(chairInvitationDto.getEmail());
        String memberType = chairInvitationDto.getMemberType();
        chairService.addMember(email, memberType);
    }

    @PostMapping("chair/sections")
    @CrossOrigin(origins = "http://localhost:4200")
    public void createSection(@RequestBody Section section){
        Section newSection = new Section();
       // newSection.setId(section.getId());
        newSection.setName(section.getName());
        newSection.setNumberOfParticipants(section.getNumberOfParticipants());
        newSection.setStartTime(section.getStartTime());
        newSection.setEndTime(section.getEndTime());

        sectionService.saveSection(newSection);
    }
}

