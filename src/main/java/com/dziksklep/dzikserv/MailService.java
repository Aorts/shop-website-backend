package com.dziksklep.dzikserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Email email) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email.getEmailAddress());
        mail.setSubject(email.getEmailTitle());
        mail.setText(email.getEmailMessage());

        javaMailSender.send(mail);
    }
}