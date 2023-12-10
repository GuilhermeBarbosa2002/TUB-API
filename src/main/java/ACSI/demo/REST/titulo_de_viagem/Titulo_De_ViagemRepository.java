package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.camara.Camara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Titulo_De_ViagemRepository extends JpaRepository<Titulo_De_Viagem,Long> {
    @Query("Select t FROM Titulo_De_Viagem t WHERE t.id = ?1")
    Optional<Titulo_De_Viagem> findTitulodeViagemById(Long id);
}
