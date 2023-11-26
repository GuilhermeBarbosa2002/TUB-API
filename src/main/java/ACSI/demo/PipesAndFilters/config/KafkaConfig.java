package ACSI.demo.PipesAndFilters.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        // Configuração do administrador Kafka
        return new KafkaAdmin(Map.of("bootstrap.servers", "localhost:9092"));
    }

    @Bean
    public NewTopic inputTopic() {
        // Configuração do tópico de entrada
        return TopicBuilder.name("Entrada").build();
    }

    @Bean
    public NewTopic outputTopic() {
        // Configuração do tópico de saída
        return TopicBuilder.name("Saida").build();
    }
}

