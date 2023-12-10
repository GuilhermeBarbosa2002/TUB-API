package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.camara.CamaraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Titulo_De_ViagemConfig {
    @Bean
    CommandLineRunner inicializarCamara(CamaraRepository repository) {
        return args -> {
        };
    }
}
