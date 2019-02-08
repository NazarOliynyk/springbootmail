package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.demo.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:application.properties")
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;



         @Autowired
         Environment env;

         public void send(String email, String message) {
             MimeMessage mimeMessage = javaMailSender.createMimeMessage();
             MimeMessageHelper helper = null;
             try {
                 helper = new MimeMessageHelper(mimeMessage, true);
             } catch (MessagingException e) {
                 e.printStackTrace();
             }
             try {
                 mimeMessage.setFrom(new InternetAddress(env.getProperty("email.username")));
                 helper.setTo(email);
                 helper.setText(message,true);
             } catch (MessagingException e) {
                 e.printStackTrace();
             }
                 javaMailSender.send(mimeMessage);

         }
}
