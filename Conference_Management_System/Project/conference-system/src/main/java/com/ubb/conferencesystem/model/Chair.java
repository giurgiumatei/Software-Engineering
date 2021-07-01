package com.ubb.conferencesystem.model;

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
//@DiscriminatorValue("chair")
public class Chair extends User{

//    @OneToOne
//    @JoinColumn(name = "conference_id", referencedColumnName = "id")
//    private Conference conference;

    public Chair(String username, String password, String email, Conference conference) {
        super(username, password, email);
//        this.conference = conference;
//        this.setType("chair");
    }
}
