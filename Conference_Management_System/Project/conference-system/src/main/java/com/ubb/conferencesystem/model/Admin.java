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
//@DiscriminatorValue("admin")
public class Admin extends User{

    public Admin(String username, String password, String email) {
        super(username, password, email);
//        this.setType("admin");
    }
}
