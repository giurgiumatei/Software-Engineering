package com.ubb.conferencesystem.controller;

import com.ubb.conferencesystem.model.Conference;
import com.ubb.conferencesystem.model.Email;
import com.ubb.conferencesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/create-conference")
    @CrossOrigin(origins = "http://localhost:4200")
    public Conference createConference(@RequestBody Conference conference) {
        return adminService.saveConference(conference);
    }

    @PostMapping("/admin/invite")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addChair(@RequestBody Email email) {
        System.out.println(email);
        adminService.createChair(email);
    }
}
