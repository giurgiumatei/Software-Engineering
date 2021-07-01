package com.ubb.conferencesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("listener")
public class Listener extends User{

//    @OneToOne
//    @JoinColumn(name = "conference_id", referencedColumnName = "id")
//    private Conference conference;

    public Listener(String username, String password, String email, Conference conference) {
        super(username, password, email);
//        this.conference = conference;
//        this.setType("listener");
    }
}
