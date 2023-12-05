package ACSI.demo.PipesAndFilters;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages/")
public class MessageController {
    //Boas
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@NonNull @RequestBody Localizacao localizacao) {
        Object currentLocationJson = String.format("{\"latitude\": %s, \"longitude\": %s, \"brt\": %s}", localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getBrt_id());
        //ir buscar os dados todos e mandar por kafka!
        kafkaTemplate.send("amigoscode", currentLocationJson);

    }
}
