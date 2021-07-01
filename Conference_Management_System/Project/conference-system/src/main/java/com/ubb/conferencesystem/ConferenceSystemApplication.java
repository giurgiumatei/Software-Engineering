package com.ubb.conferencesystem;

import com.ubb.conferencesystem.model.*;
import com.ubb.conferencesystem.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ConferenceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceSystemApplication.class, args);
	}

	/*@Bean
    CommandLineRunner commandLineRunner(PaperRepository paperRepository,
                                        AuthorRepository authorRepository,
                                        ConferenceRepository conferenceRepository,
                                        ChairRepository chairRepository,
                                        ListenerRepository listenerRepo) {
        return args -> {
            Paper paper1 = new Paper("title1", "content1", true);
            Paper paper2 = new Paper("title2", "content2");
            Author author = new Author("auth", "qwe", "asd@gmail.com");
            authorRepository.save(author);
            Proposal prop1 = new Proposal("titlep1", "contentp1", author);
            paperRepository.save(paper1);
            paperRepository.save(paper2);
            paperRepository.save(prop1);

            Conference conference = new Conference("conference", LocalDate.of(2021, 3, 31),LocalDate.of(2021,4,3));
            conferenceRepository.save(conference);
            Chair chair = new Chair("user", "password", "chair@email.com", conference);
            chairRepository.save(chair);

            Listener listener = new Listener("user", "password", "email@email.com", conference);
            listenerRepo.save(listener);
        };
    }*/
}
