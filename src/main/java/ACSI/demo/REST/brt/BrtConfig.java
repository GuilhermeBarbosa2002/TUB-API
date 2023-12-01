package ACSI.demo.REST.brt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BrtConfig {
    @Bean
    CommandLineRunner inicializarBrt(BrtRepository repository) {
        return args -> {
            Brt brt1 = new Brt("34-MO-PQ", LocalDate.parse("2002-02-22"),20);
            Brt brt2 = new Brt("29-EE-11",LocalDate.parse("2005-05-05"),21);
            repository.saveAll(List.of(brt1, brt2));
        };
    }

}
