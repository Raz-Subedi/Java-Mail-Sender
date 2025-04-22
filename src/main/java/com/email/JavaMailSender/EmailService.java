package com.email.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,String subject,String body){

        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(toEmail);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);


        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

