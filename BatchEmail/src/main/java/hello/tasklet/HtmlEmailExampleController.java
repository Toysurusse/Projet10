package hello.tasklet;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlEmailExampleController {

    @Autowired
    public MailConfig emailSender;

    @ResponseBody
    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail(String mail, String pseudo, String bookName) throws MessagingException {

        MimeMessage message = emailSender.getJavaMailSender().createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        String htmlMsg = "<h1>Bonjour " +pseudo+"</h1>"+
                "<p>Les délais de prêt sont dépassés. Merci de rendre votre livre dont le titre est "+ bookName +"</p>";

        System.out.println(htmlMsg);

        message.setContent(htmlMsg, "text/html");
        helper.setTo(mail);
        helper.setSubject("Livre en retard");
        this.emailSender.getJavaMailSender().send(message);

        return "Email Sent!";
    }

}
