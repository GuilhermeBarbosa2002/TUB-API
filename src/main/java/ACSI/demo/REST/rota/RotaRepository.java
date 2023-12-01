package ACSI.demo.REST.rota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RotaRepository extends JpaRepository<Rota, Long> {
    @Query("Select p FROM Rota p WHERE p.nome = ?1")
    Optional<Rota> findRotaByNome(String nome);
}
