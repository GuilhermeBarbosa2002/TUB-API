package ACSI.demo.REST.movimento;

import ACSI.demo.REST.paragem.Paragem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

}
