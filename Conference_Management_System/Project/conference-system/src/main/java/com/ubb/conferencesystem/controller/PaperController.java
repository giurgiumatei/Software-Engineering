package com.ubb.conferencesystem.controller;

import com.ubb.conferencesystem.model.Conference;
import com.ubb.conferencesystem.model.Paper;
import com.ubb.conferencesystem.service.AuthorService;
import com.ubb.conferencesystem.service.ConferenceService;
import com.ubb.conferencesystem.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;


@RestController
public class PaperController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/pcmember")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Paper> getAllPapers(){
        return paperService.findAll();
    }

    @RequestMapping(path = "/submit-paper/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Paper submitPaper(@PathVariable Long id ,
                             @RequestBody Map<String, Object> data) throws Exception {

        var paperData = (LinkedHashMap<String, String>)data.get("paper");
        Paper paper = new Paper(
                paperData.get("title"),
                paperData.get("content"),
                Boolean.TRUE
        );
        String title = paper.getTitle();
        Long conferenceId = Long.valueOf((Integer)data.get("conferenceId")) ;

        // get all papers by the conference having id=conferenceId
        List<Paper> allPapersByConference = conferenceService.findById(conferenceId).getPapers();

        // add the newly created paper to it's list of papers
        allPapersByConference.add(
                paper
        );

        Paper paperFetched = null;
        if (title != null && !title.equals("")) {
            paperFetched = paperService.fetchPaperByTitle(title);
            if (paperFetched != null) {
                throw new Exception("Paper with " + title + " already exists!");
            }
        }
        if(paper.getAccepted() == null)
            paper.setAccepted(false);
        paper.setAuthor(authorService.fetchAuthorById(id));

        return paperService.savePaper(paper);
    }

}
