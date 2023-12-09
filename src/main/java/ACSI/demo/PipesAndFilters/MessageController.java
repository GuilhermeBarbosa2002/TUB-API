package ACSI.demo.PipesAndFilters;

import ACSI.demo.REST.brt.BrtRepository;
import ACSI.demo.REST.brt.BrtService;
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

    private final BrtService brtService;
    public MessageController(KafkaTemplate<String, Object> kafkaTemplate, BrtService brtService) {
        this.kafkaTemplate = kafkaTemplate;
        this.brtService = brtService;

    }

    @PostMapping
    public void publish(@NonNull @RequestBody Localizacao localizacao) {
        Object currentLocationJson = String.format("{\"latitude\": %s, \"longitude\": %s, \"brt\": %s}", localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getBrt_id());
        //ir buscar os dados todos e mandar por kafka!
        brtService.updateLocalizacao(localizacao.getBrt_id(), localizacao.getLatitude(), localizacao.getLongitude());
        kafkaTemplate.send("amigoscode", currentLocationJson);

    }
}
