package ACSI.demo.REST.viagem;

import ACSI.demo.REST.brt.Brt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    @Query("Select v FROM Viagem v WHERE v.id = ?1")
    Optional<Viagem> findViagemById(Long id);


    @Query("SELECT v FROM Viagem v JOIN v.brt b WHERE b.id = ?1 and v.estado = ?2 ")
    Optional<Viagem> findViagemByBrt(Long idBrt, EstadoViagem estadoViagem);
}