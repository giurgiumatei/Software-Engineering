package com.ubb.conferencesystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("pcmember")
public class PCMember extends Author{

    public PCMember(String username, String password, String email) {
        super(username, password, email);
//        this.setType("pcmember");
    }
}
