package jobhunter.emailservice.listener;

import jobhunter.emailservice.model.Email;
import jobhunter.emailservice.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    EmailSender emailSender;

    @KafkaListener(topics = "email", groupId = "group_email", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEmail(Email email) {
        System.out.println("Consumed JSON Message: " + email);
        emailSender.sendEmail(email.getEmail(), email.getSubject(), email.getBody());
    }

}
