package ACSI.demo.REST.viagem;

import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.brt.BrtRepository;
import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraRepository;
import ACSI.demo.REST.camara.EstadoCamara;
import ACSI.demo.REST.motorista.Motorista;
import ACSI.demo.REST.motorista.MotoristaRepository;
import ACSI.demo.REST.movimento.Movimento;
import ACSI.demo.REST.movimento.MovimentoRepository;
import ACSI.demo.REST.paragem.Paragem;
import ACSI.demo.REST.paragem.ParagemRepository;
import ACSI.demo.REST.rota.Rota;
import ACSI.demo.REST.rota.RotaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ViagemConfig {
    @Bean
    CommandLineRunner inicializarViagem(ViagemRepository viagemRepository, ParagemRepository paragemRepository, RotaRepository rotaRepository, MotoristaRepository motoristaRepository, CamaraRepository camaraRepository, BrtRepository brtRepository, MovimentoRepository movimentoRepository) {
        return args -> {
            Paragem paragem1 = new Paragem("Ponte de Prado", "41.594079223736614", "-8.459348645833831");
            Paragem paragem2 = new Paragem("Merelim S. Roque", "41.58262647285251", "-8.467006107577262 ");
            Paragem paragem3 = new Paragem("Caires", "41.174585915885858585885858", "-8.636844715646456456");
            Paragem paragem4 = new Paragem("25 de abril (parque infantil)", "41.54800195302043", "-8.419265442121052");
            Paragem paragem5 = new Paragem("Bom jesus", "41.554445132302604", "-8.381090401263272");

            // Salvar paragens
            paragemRepository.saveAll(List.of(paragem1, paragem2, paragem3, paragem4, paragem5));

            // Criar rota e associar paragens
            Rota rota = new Rota("Rota dos Arcos", null, List.of(paragem1, paragem2, paragem3, paragem4, paragem5),"C1",34);
            rotaRepository.save(rota);

            Motorista motorista = new Motorista("Ze", "ze@gmail.com", "253930664", "918048445", LocalDate.of(1983, 5, 31));
            motoristaRepository.save(motorista);

            Camara camara1 = new Camara("ModeloX123", "ABC123", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.DEFEITUOSA);
            Camara camara2 = new Camara("ModeloX123", "ABC1234", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.MANUTENCAO);
            Camara camara3 = new Camara("ModeloX123", "ABC12345", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.DEFEITUOSA);
            Camara camara4 = new Camara("ModeloX123", "ABC123456", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.MANUTENCAO);
            Camara camara5 = new Camara("ModeloX123", "ABC1234567", LocalDate.now(), "MarcaA", "1920x1080", EstadoCamara.MANUTENCAO);
            camaraRepository.saveAll(List.of(camara1, camara2,camara3,camara4,camara5));

            Brt brt = new Brt("34-MO-PQ", LocalDate.parse("2002-02-22"), 20, List.of(camara1, camara2));
            brtRepository.save(brt);


            Movimento movimento = new Movimento(paragem1, 12L, 12L,11.2);
            movimentoRepository.save(movimento);
            Viagem viagem = new Viagem(LocalDateTime.of(2023, 11, 25, 13, 22), EstadoViagem.EM_VIAGEM, rota, motorista, brt, 12L, 12L, List.of(movimento));

            viagemRepository.save(viagem);
        };
    }
}
