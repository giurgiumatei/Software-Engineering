package com.ubb.conferencesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("author")
public class Author extends User{

    public Author(String username, String password, String email) {
        super(username, password, email);
//        this.setType("author");
    }


}
