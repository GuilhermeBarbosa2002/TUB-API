package ACSI.demo.REST.camara;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CamaraRepository extends JpaRepository<Camara, Long> {
    @Query("Select c FROM Coroa c WHERE c.nrSerie = ?1")
    Optional<Camara> findCamaraByNumSerie(String numero);
}
