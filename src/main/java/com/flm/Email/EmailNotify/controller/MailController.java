//package com.flm.Email.EmailNotify.controller;
//
//import com.flm.Email.EmailNotify.model.MailRequest;
//import com.flm.Email.EmailNotify.notification.EmailService;
//import jakarta.mail.MessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class MailController {
//
//    private final EmailService emailService;
//   @PostMapping("/send")
//    public String SendEmail(@RequestBody MailRequest request) {
//        emailService.SendEmail(request.getTo(),request.getSubject(),request.getBody());
//        return "mail sent successfully";
//    }
//}
