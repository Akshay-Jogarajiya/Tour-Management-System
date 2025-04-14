package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-message")
    public String sendMessage(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message
    ) {
        String recipient = "jogarajiyaakshay@gmail.com";  // Replace with your recipient email

        String emailContent = "You have received a new message from " + name + " (" + email + "):\n\n" + message;
        emailService.sendEmail(recipient, subject, emailContent , email);

        return "contact_us";
    }
}
