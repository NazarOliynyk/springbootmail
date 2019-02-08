package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.MailService;

@Controller
public class MainController {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendMessage")
    public String sendMessage(
            @RequestParam String email,
            @RequestParam String message
    ){
        mailService.send(email, message);
        return "redirect:/";
    }
}
