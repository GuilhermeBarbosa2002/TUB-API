package ACSI.demo.REST.motorista;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MotoristaConfig {
    @Bean
    CommandLineRunner inicializarMotorista(MotoristaRepository repository) {
        return args -> {
            //Motorista motorista1 = new Motorista("Ze","ze@gmail.com","253930664","918048445", LocalDate.of(1983,05,31));
        };
    }

}
