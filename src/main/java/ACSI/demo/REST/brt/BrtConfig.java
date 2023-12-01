package ACSI.demo.REST.brt;

import ACSI.demo.REST.camara.CamaraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrtConfig {

    @Bean
    CommandLineRunner inicializarBrt(BrtRepository repository, CamaraRepository repositoryCamara) {
        return args -> {
//            Camara camara1 = new Camara("ModeloX123", "ABC123", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.DEFEITUOSA);
//            Camara camara2 = new Camara("ModeloX123", "ABC1234", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.MANUTENCAO);
//            repositoryCamara.saveAll(List.of(camara1,camara2));
//            Brt brt1 = new Brt("34-MO-PQ", LocalDate.parse("2002-02-22"),20, List.of(camara1,camara2));
//            repository.save(brt1);
        };
    }

}
