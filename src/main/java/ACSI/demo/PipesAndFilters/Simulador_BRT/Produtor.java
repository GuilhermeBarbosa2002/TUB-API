package ACSI.demo.PipesAndFilters.Simulador_BRT;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class Produtor {

    @GetMapping("/coordinates")
    public ResponseEntity<String> getCoordinates() {
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
            return ResponseEntity.status(500).body("Erro ao analisar JSON");
        }

        // Iterando sobre as entidades para encontrar a entidade com o ID desejado
        for (JsonNode entityNode : jsonNode) {
            String entityId = entityNode.path("id").asText();

            // Verificando se a entidade tem o ID desejado
            if ("urn:ngsi-ld:Vehicle:porto:stcp:bus:3347".equals(entityId)) {
                // Extraindo latitude e longitude do JSON
                JsonNode locationNode = entityNode.path("location");
                JsonNode coordinatesNode = locationNode.path("value").path("coordinates");
                double latitude = coordinatesNode.get(1).asDouble();  // Índice 1 para latitude
                double longitude = coordinatesNode.get(0).asDouble(); // Índice 0 para longitude

                // Agora você tem latitude e longitude, e pode fazer o que quiser com elas
                // Neste exemplo, eu só estou retornando uma string com as coordenadas
                String result = "Latitude: " + latitude + ", Longitude: " + longitude;

                return ResponseEntity.ok(result);
            }
        }

        // Caso o ID desejado não seja encontrado
        return ResponseEntity.status(404).body("Entidade não encontrada para o ID especificado");
    }
}
