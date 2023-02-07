package com.northlas.supportportal.service;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static com.northlas.supportportal.constant.EmailConstant.*;
import static javax.mail.Message.RecipientType.CC;
import static javax.mail.Message.RecipientType.TO;
import static javax.mail.internet.InternetAddress.*;

@Service
public class EmailService {
    public void sendNewPasswordEmail(String firstName, String password, String email) throws MessagingException {
        Message message = createEmail(firstName, password, email);
        SMTPTransport smtpTransport = (SMTPTransport) getEmailSession().getTransport(SIMPLE_MAIL_TRANSFER_PROTOCOL);

        smtpTransport.connect(GMAIL_SMTP_SERVER, DEFAULT_PORT, USERNAME, PASSWORD);
        smtpTransport.sendMessage(message, message.getAllRecipients());
        smtpTransport.close();
    }

    private Message createEmail(String firstName, String password, String email) throws MessagingException {
        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress(FROM_EMAIL));
        message.setRecipients(TO, parse(email, false));
        message.setRecipients(CC, parse(CC_EMAIL, false));
        message.setSubject(EMAIl_SUBJECT);
        message.setText("Hello " + firstName + ", \n\nYour new account password is: " + password + "\n\nThe Support Team");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    private Session getEmailSession() {
        Properties properties = System.getProperties();
        properties.put(SMTP_HOST, GMAIL_SMTP_SERVER);
        properties.put(SMTP_AUTH, true);
        properties.put(SMTP_PORT, DEFAULT_PORT);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put(SMTP_STARTTLS_ENABLE, true);
        properties.put(SMTP_STARTTLS_REQUIRED, true);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.enable", true);
        properties.setProperty("mail.smtp.proxy.host", "kpproxygsit");
        properties.setProperty("mail.smtp.proxy.port", "8080");
        properties.setProperty("mail.smtp.proxy.user", "U547086");
        properties.setProperty("mail.smtp.proxy.password", "malioxlager1470");
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        });
    }
}
