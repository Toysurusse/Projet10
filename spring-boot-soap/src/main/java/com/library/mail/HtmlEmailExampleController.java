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
        String book="";

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
                String htmlMsg = "<h1>Bonjour ";
            if (mailList.size()==1){
                htmlMsg = "<h1>Bonjour " +mailList.get(0).getPseudo()+"</h1>"+
                        "<p>le prêt de votre livre "+ mailList.get(0).getBookname() +" est enregistré. Nos agents sont à votre disposition pour mettre vous remettre vos livres </p>";
            }
            else {
                for (Latebook l : mailList
                        ) {
                    book = book + l.getBookname() + "<br>";
                }
                htmlMsg = "<h1>Bonjour " + mailList.get(0).getPseudo() + "</h1>" +
                        "<p>le prêt des livres suivant est enregistré : <br>"
                        + book +
                        " est enregistré. Nos agents sont à votre disposition pour mettre vous remettre vos livres </p>";
            }
            message.setContent(htmlMsg, "text/html");
            helper.setTo(mailList.get(0).getMail());
            helper.setSubject("Location livre");
            this.emailSender.getJavaMailSender().send(message);
        return "Email Sent!";
    }

}

