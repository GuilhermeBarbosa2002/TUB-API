package ACSI.demo.REST.viagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    @Query("Select v FROM Viagem v WHERE v.id = ?1")
    Optional<Viagem> findViagemById(Long id);
}