package ACSI.demo.REST.motorista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    @Query("Select m FROM Motorista m WHERE m.nome = ?1")
    Optional<Motorista> findMotoristaByNome(String nome);
}
