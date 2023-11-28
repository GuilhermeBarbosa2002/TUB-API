package ACSI.demo;

import ACSI.demo.PipesAndFilters.Simulador_BRT.Produtor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunnerr(KafkaTemplate<String, Object> kafkaTemplate) {
        Produtor produtor = new Produtor(kafkaTemplate);

		return args -> {
			for (int i = 0; i < 100; i++) {
                // kafkaTemplate.send("amigoscode", "raul : " + i);
			}

        };
	}


}