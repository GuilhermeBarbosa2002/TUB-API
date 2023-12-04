package ACSI.demo.REST.brt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BrtRepository extends JpaRepository<Brt,Long> {
    @Query("Select s FROM Brt s WHERE s.matricula = ?1")
    Optional<Brt> findBrtByMatricula(String matricula);

    @Query("SELECT b FROM Brt b JOIN b.camaras c WHERE c.id = ?1")
    Optional<Brt> findBrtByCamera(Long idCamera);


}
