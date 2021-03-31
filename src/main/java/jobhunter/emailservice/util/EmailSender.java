package jobhunter.emailservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String recipient, String subject, String body) {

        try {

            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setTo(recipient);
            helper.setText(body, true);

            mailSender.send(message);
            System.out.println("Mail send successfully");

        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
