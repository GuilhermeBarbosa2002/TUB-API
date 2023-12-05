package ACSI.demo.PipesAndFilters;

import ACSI.demo.REST.brt.BrtService;
import ACSI.demo.REST.movimento.Movimento;
import ACSI.demo.REST.movimento.MovimentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Component
public class KafkaListeners {
    private final BrtService brtService;

    @Autowired
    public KafkaListeners(BrtService brtService) {
        this.brtService = brtService;
    }


    @KafkaListener(topics = "amigoscode", groupId = "groupId")
    void listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println(value);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Localizacao localizacao = objectMapper.readValue(value, Localizacao.class);

            brtService.updateLocalizacao(localizacao.getBrt_id(), localizacao.getLatitude(), localizacao.getLongitude());

        } catch (Exception e) {
            System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
        }
    }


}
