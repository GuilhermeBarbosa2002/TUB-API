package ACSI.demo.REST.paragem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ParagemRepository extends JpaRepository<Paragem, Long> {
    @Query("Select p FROM Paragem p WHERE p.nome = ?1")
    Optional<Paragem> findParagemByNome(String nome);
}
