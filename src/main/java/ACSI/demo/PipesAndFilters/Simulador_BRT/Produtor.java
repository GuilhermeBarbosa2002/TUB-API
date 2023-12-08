package ACSI.demo.PipesAndFilters.Simulador_BRT;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

@Component

public class Produtor {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String lastLocationJson = "";
    private String currentLocationJson;

    @Autowired

    public Produtor(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

        // Inicia o timer para executar a tarefa a cada 5 segundos
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new LocationUpdateTask(), 0, 5000);

    }


    private class LocationUpdateTask extends TimerTask {
        @Override
        public void run() {
            updateLocation();
        }
    }
    public void updateLocation() {
        String apiUrl = "https://broker.fiware.urbanplatform.portodigital.pt/v2/entities?q=vehicleType==bus&limit=1000";

        // Fazendo uma chamada à API e obtendo os dados como String
        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForObject(apiUrl, String.class);

        // Usando Jackson para analisar o JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(apiResponse);
        } catch (Exception e) {
            // Lidar com erros ao analisar JSON
            return;
        }

        // Iterando sobre as entidades para encontrar a entidade com o ID desejado
        int i = 1;
        for (JsonNode entityNode : jsonNode) {
            String entityId = entityNode.path("id").asText();
            if(i==1) {
                // Verificando se a entidade tem o ID desejado
                if ("urn:ngsi-ld:Vehicle:porto:stcp:bus:3347".equals(entityId)) {
                    // Extraindo latitude e longitude do JSON
                    JsonNode locationNode = entityNode.path("location");
                    JsonNode coordinatesNode = locationNode.path("value").path("coordinates");
                    double latitude = coordinatesNode.get(1).asDouble();  // Índice 1 para latitude
                    double longitude = coordinatesNode.get(0).asDouble(); // Índice 0 para longitude


                    // Criando o objeto Location com as coordenadas
                    Object currentLocationJson = String.format("{\"latitude\": %s, \"longitude\": %s, \"brt\": %s}", latitude, longitude, 1);

                    i=i-1;
                    kafkaTemplate.send("amigoscode", "Localizacao_"+currentLocationJson);

                    // Não é necessário continuar procurando, pois encontramos a entidade desejada

                }
            }
            else
            {
                if ("urn:ngsi-ld:Vehicle:porto:stcp:bus:2142".equals(entityId)) {

                    System.err.println("TOU AQUIIIIIIIIII");
                    // Extraindo latitude e longitude do JSON
                    JsonNode locationNode = entityNode.path("location");
                    JsonNode coordinatesNode = locationNode.path("value").path("coordinates");
                    double latitude = coordinatesNode.get(1).asDouble();  // Índice 1 para latitude
                    double longitude = coordinatesNode.get(0).asDouble(); // Índice 0 para longitude


                    // Criando o objeto Location com as coordenadas
                    Object currentLocationJson = String.format("{\"latitude\": %s, \"longitude\": %s, \"brt\": %s}", latitude, longitude, 1);
                        kafkaTemplate.send("amigoscode", "Localizacao_" + currentLocationJson);
                        kafkaTemplate.send("amigoscode", "Brt_Post_26-32-MV_2023-12-12_45_3_4");
                        kafkaTemplate.send("amigoscode", "Brt_Put_1_63");
                        kafkaTemplate.send("amigoscode", "Brt_Get_1");
                        kafkaTemplate.send("amigoscode", "Brt_GetAll");
                    // Não é necessário continuar procurando, pois encontramos a entidade desejada

                }
            }
        }
    }
}
