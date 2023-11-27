package ACSI.demo.PipesAndFilters;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "amigoscode", groupId = "groupId")
    void listener(Object data) {
        System.out.println("Listener received " + data.toString() + " <3");
    }
}
