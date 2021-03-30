package jobhunter.emailservice.listener;

import jobhunter.emailservice.model.Email;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "email", groupId = "group_email", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEmail(Email email) {
        System.out.println("Consumed JSON Message: " + email);
    }

}
