package com.library.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.library.Latebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HtmlEmailExampleController {

    @Autowired
    public MailConfig emailSender;

    @ResponseBody
    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail(List<Latebook> mailList) throws javax.mail.MessagingException {

        javax.mail.internet.MimeMessage message = emailSender.getJavaMailSender().createMimeMessage();
        boolean multipart = true;

        for (Latebook m : mailList) {
            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
            String htmlMsg = "<h1>Bonjour " +m.getPseudo()+"</h1>"+
                    "<p>le prêt de votre livre "+ m.getBookname() +" est enregistré. Nos agents sont à votre disposition pour mettre à disposition vos livres </p>";
            message.setContent(htmlMsg, "text/html");
            helper.setTo(m.getMail());
            helper.setSubject("Livre en retard");
            this.emailSender.getJavaMailSender().send(message);
        }


        return "Email Sent!";
    }

}

