package com.ubb.conferencesystem.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

//    @OneToMany
//    private List<Section> sections = new ArrayList<>();

    @OneToMany
    private List<Paper> papers = new ArrayList<>();

    public Conference(String name, LocalDate startTime, LocalDate endTime) {
        this.name = name;
        this.startDate = startTime;
        this.endDate = endTime;
    }

    public Conference(String name, LocalDate startTime, LocalDate endTime, List<Paper> papers) {
        this.name = name;
        this.startDate = startTime;
        this.endDate = endTime;
        this.papers = papers;
    }

}

