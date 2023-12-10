package ACSI.demo.PipesAndFilters;

import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.brt.BrtService;
import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class KafkaListeners {
    private final BrtService brtService;
    private final CamaraService camaraService;
    @Autowired
    public KafkaListeners(BrtService brtService, CamaraService camaraService) {
        this.brtService = brtService;
        this.camaraService = camaraService;
    }
    @KafkaListener(topics = "localizacao", groupId = "localizacaoid")
    void listenerlocalizacao(ConsumerRecord<String, String> record) {
        String[] value = record.value().split("_");
        LocalizacaoCommandos(value);
    }
    @KafkaListener(topics = "brt", groupId = "brtid")
    void listenerbrt(ConsumerRecord<String, String> record) {
        String[] value = record.value().split("_");
        BrtCommandos(value);
    }
    private void BrtCommandos(String[] value) {
        switch (value[1]) {
            case "GetAll":
                System.out.println(brtService.getBrts());
                break;
            case "Get":
                System.out.println(brtService.getBrtById(Long.parseLong(value[2])));
                break;
            case "Delete":
                brtService.deleteBrt(Long.parseLong(value[2]));
                break;
            case "Put":
                brtService.uptadeBrt(Long.parseLong(value[2]),Integer.parseInt(value[3]));
                break;
            case "Post":
                List<Camara> camaras = new ArrayList<>();
                for (int i = 5; i <= (value.length - 1); i++) {
                    Long valor = Long.parseLong(value[i]);
                    try {
                        camaras.add(camaraService.getCamaraById(valor));
                    } catch (Exception e) {
                        System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
                    }
                }
                System.out.println(value[2]);
                Brt brt = new Brt(value[2], LocalDate.parse(value[3]), Integer.parseInt(value[4]), camaras);
                brtService.addNewBrt(brt);
                break;
            default:
                System.out.println("Comando Brt não reconhecido: " + value[1]);
                break;
        }
    }
    private void LocalizacaoCommandos(String[] value) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Localizacao localizacao = objectMapper.readValue(value[1], Localizacao.class);
            brtService.updateLocalizacao(localizacao.getBrt_id(), localizacao.getLatitude(), localizacao.getLongitude());
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
        }
    }
}
