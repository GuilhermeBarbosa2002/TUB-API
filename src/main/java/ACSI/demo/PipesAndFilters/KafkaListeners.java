package ACSI.demo.PipesAndFilters;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "amigoscode", groupId = "groupId")
    void listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println(value);
    }
}
