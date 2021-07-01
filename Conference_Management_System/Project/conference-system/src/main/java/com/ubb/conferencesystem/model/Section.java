package com.ubb.conferencesystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberOfParticipants;
    private String name;
    private LocalDate startTime;
    private LocalDate endTime;

    public Section(Integer numberOfParticipants, String name, LocalDate startTime, LocalDate endTime) {
        this.numberOfParticipants = numberOfParticipants;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
