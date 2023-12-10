package ACSI.demo.REST.coroa;

import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CoroaService {
    private final CoroaRepository coroaRepository;

    @Autowired
    public CoroaService(CoroaRepository coroaRepository) {
        this.coroaRepository = coroaRepository;
    }

    public List<Coroa> getCamaras() {
        return coroaRepository.findAll();
    }

    public void addNewCoroa(Coroa coroa) {


        coroaRepository.save(coroa);
    }

    public void deleteCoroa(Long id) {
        boolean bool = coroaRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma Coroa com esse Id"));

        }

        coroaRepository.deleteById(id);
    }

    @Transactional
    public void uptadeCoroa(Long id, Coroa coroa) {
        Coroa existingCoroa = coroaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Coroa not found"));

        existingCoroa.setRotas(coroa.getRotas());
        existingCoroa.setPrice(coroa.getPrice());


    }

    public Coroa getCoroaById(Long id) {
        Coroa existCoroa = coroaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Coroa not found"));

        return existCoroa;

    }
}
