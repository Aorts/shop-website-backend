package com.dziksklep.dzikserv;


import org.springframework.stereotype.Component;

@Component
public class Email {

    private String emailAddress;
    private String fromEmailAddress;
    private String emailTitle;
    private String emailMessage;

    public Email(String emailAddress, String fromEmailAddress, String emailTitle, String emailMessage) {
        this.emailAddress = emailAddress;
        this.fromEmailAddress = fromEmailAddress;
        this.emailTitle = emailTitle;
        this.emailMessage = emailMessage;
    }

    public Email() {
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                ", fromEmailAddress='" + fromEmailAddress + '\'' +
                ", emailTitle='" + emailTitle + '\'' +
                ", emailMessage='" + emailMessage + '\'' +
                '}';
    }
}