//package com.flm.Email.EmailNotify.notification;
//
//import com.flm.Email.EmailNotify.model.MailRequest;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Value("${spring.mail.username}")
//    private String senderEmail;
//
//    public void SendEmail(String to, String subject, String body) {
//        try{
//            MimeMessage message = javaMailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setFrom(senderEmail);
//        helper.setSubject(subject);
//        helper.setText(buildEmailContent(body), true);
//
//        javaMailSender.send(message);
//      System.out.println( "html email sent successfully");
//    }catch(MessagingException e) {
//            e.printStackTrace();
//            System.out.println("Failed to send email");
//        }
//
//    }
//    private String buildEmailContent(String body){
//                return "<html>" +
//                        "<body>" +
//                        "<h1 style='color:blue;'>Welcome!</h1>" +
//                        "<p>" + body + "</p>" +
//                        "<br><br>" +
//                        "<footer><small>Regards,<br>Company Team</small></footer>" +
//                        "</body>" +
//                        "</html>";
//            }
//
//
//}
//
//
//
//
