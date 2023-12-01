package ACSI.demo.REST.rota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RotaRepository extends JpaRepository<Rota, Long> {
    @Query("Select r FROM Rota r WHERE r.nome = ?1")
    Optional<Rota> findRotaByNome(String nome);
}
