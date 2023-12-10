package ACSI.demo.REST.coroa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CoroaRepository extends JpaRepository<Coroa, Long> {


}
