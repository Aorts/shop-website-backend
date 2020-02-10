package com.dziksklep.dzikserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class RegistrationController {

    @Autowired
    private MailService notificationService;

    @PostMapping("/send-mail")
    public ResponseEntity<String> send(@RequestBody Email emailData) {

        emailData.setEmailAddress("example@gmail.com");  //Receiver's email address
        emailData.setEmailMessage("Wiadomość od: "+emailData.getFromEmailAddress()+"\n"+emailData.getEmailMessage());


        try {
            notificationService.sendEmail(emailData);
        } catch (MailException mailException) {
            System.out.println(mailException);
            return new ResponseEntity<>("Error during sending email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Email sent", HttpStatus.OK);
    }
}