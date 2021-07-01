package com.ubb.conferencesystem.service;

import com.ubb.conferencesystem.model.Chair;
import com.ubb.conferencesystem.model.Email;
import com.ubb.conferencesystem.model.PCMember;
import com.ubb.conferencesystem.model.User;
import com.ubb.conferencesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ChairService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    public void addMember(Email email, String memberType) throws MailException {
        System.out.println(email);
        System.out.println(memberType);
        String emailString = email.getEmail();
        String username = emailString.split("@")[0];
        String password = generatePassword();

        //Add member to database
        if(memberType.equals("Chair")) {
            Chair user = new Chair();
            user.setUsername(username);
            user.setEmail(emailString);
            user.setPassword(password);
            user.setType("chair");
            if(user != null)
                userRepository.save(user);
            System.out.println(user);
        }
        else if(memberType.equals("PC Member")) {
            PCMember user = new PCMember();
            user.setUsername(username);
            user.setEmail(emailString);
            user.setPassword(password);
            user.setType("pcmember");
            if(user != null)
                userRepository.save(user);
            System.out.println(user);
        }

        StringBuilder body = new StringBuilder();
        body.append("Welcome to the Conference Management System!\n")
                .append("You are a new " + memberType + "\n")
                .append("Your credentials are:\n")
                .append("username: ")
                .append(username)
                .append("\npassword: ")
                .append(password)
                .append("\nFor any problems please contact us.");

        //send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailString);
        mail.setFrom("teamiss2021@gmail.com");
        mail.setSubject("Conference System Platform");
        mail.setText(body.toString());

        javaMailSender.send(mail);

    }

    private String generatePassword() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 10;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
