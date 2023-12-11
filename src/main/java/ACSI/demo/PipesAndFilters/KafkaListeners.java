package ACSI.demo.PipesAndFilters;

import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.brt.BrtService;
import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraService;
import ACSI.demo.REST.rota.Rota;
import ACSI.demo.REST.rota.RotaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class KafkaListeners {
    private final BrtService brtService;
    private final CamaraService camaraService;
    private final RotaService rotaService;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public KafkaListeners(BrtService brtService, CamaraService camaraService, RotaService rotaService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.brtService = brtService;
        this.camaraService = camaraService;
        this.rotaService = rotaService;
        this.kafkaTemplate = kafkaTemplate;
    }
    @KafkaListener(topics = "localizacao", groupId = "localizacaoid")
    void listenerlocalizacao(ConsumerRecord<String, String> record) {
        try {
            Localizacao localizacao = objectMapper.readValue(record.value(), Localizacao.class);
            System.out.println(localizacao.toString());
            brtService.updateLocalizacao(localizacao.getBrt_id(), localizacao.getLatitude(), localizacao.getLongitude());
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
        }
    }
    @KafkaListener(topics = "brt", groupId = "brtid")
    void listenerbrt(ConsumerRecord<String, String> record) {
        String[] value = record.value().split("_");
        BrtCommandos(value);
    }
    private void BrtCommandos(String[] value) {
        switch (value[0]) {
            case "GetAll":
                List<Brt> brts = brtService.getBrts();
                List<String> brtsJson = new ArrayList<>();
                for (Brt brt : brts) {
                    try {
                        String brtJson = objectMapper.writeValueAsString(brt);
                        brtsJson.add(brtJson);
                    } catch (JsonProcessingException e) {
                        System.err.println(e.getMessage());; // Trate a exceção conforme necessário
                    }
                }
                kafkaTemplate.send("brt",brtsJson);
                break;
            case "Get":
                System.out.println(brtService.getBrtById(Long.parseLong(value[1])));
                break;
            case "Delete":
                brtService.deleteBrt(Long.parseLong(value[1]));
                break;
            case "Put":
                brtService.uptadeBrt(Long.parseLong(value[1]),Integer.parseInt(value[2]));
                break;
            case "Post":
                List<Camara> camaras = new ArrayList<>();
                for (int i = 4; i <= (value.length - 1); i++) {
                    Long valor = Long.parseLong(value[i]);
                    try {
                        camaras.add(camaraService.getCamaraById(valor));
                    } catch (Exception e) {
                        System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
                    }
                }
                System.out.println(value[1]);
                Brt brt = new Brt(value[1], LocalDate.parse(value[2]), Integer.parseInt(value[3]), camaras);
                brtService.addNewBrt(brt);
                break;
            default:
                System.out.println("Comando Brt não reconhecido: " + value[1]);
                break;
        }
    }

    @KafkaListener(topics = "rota", groupId = "rotaid")
    void listenerRota(ConsumerRecord<String, String> record) {
        String[] value = record.value().split("_");
        RotaCommandos(value);
    }
    private void RotaCommandos(String[] value) {
        switch (value[0]) {
            case "GetAll":
                ArrayList<Rota> rotas = new ArrayList<>(rotaService.getRotas());
                Object rota = "";
                for(int i = 0 ; i<rotas.size() ; i++){
                    rota += String.format("_{\"id\": %s, \"nome\": \"%s\", \"preco\": %s, \"coroa\": \"%s\"}",rotas.get(i).getId(),rotas.get(i).getNome(),rotas.get(i).getPreco() , rotas.get(i).getCoroa());
                }
                kafkaTemplate.send("rota","GetAllR" + rota);
                break;
            case "Get":
                System.out.println(rotaService.getRotaById(Long.parseLong(value[2])));
                break;
            case "Delete":
                rotaService.deleteRota(Long.parseLong(value[2]));
                break;
            case "Put":
                // rotaService.uptadeRota(Long.parseLong(value[2]),Integer.parseInt(value[3]));
                break;
            case "Post":
//                List<Camara> camaras = new ArrayList<>();
//                for (int i = 4; i <= (value.length - 1); i++) {
//                    Long valor = Long.parseLong(value[i]);
//                    try {
//                        camaras.add(camaraService.getCamaraById(valor));
//                    } catch (Exception e) {
//                        System.err.println("Erro ao converter JSON para objeto Localizacao: " + e.getMessage());
//                    }
//                }
//                System.out.println(value[2]);
//                Brt brt = new Brt(value[2], LocalDate.parse(value[3]), Integer.parseInt(value[4]), camaras);
//                brtService.addNewBrt(brt);
                break;
            default:
                System.out.println("Comando Service não reconhecido: " + value[1]);
                break;
        }
    }
}
