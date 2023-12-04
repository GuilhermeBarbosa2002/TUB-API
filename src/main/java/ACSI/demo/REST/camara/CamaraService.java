package ACSI.demo.REST.camara;

import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CamaraService {
    private final CamaraRepository camaraRepository;

    @Autowired
    public CamaraService(CamaraRepository camaraRepository) {
        this.camaraRepository = camaraRepository;
    }

    public List<Camara> getCamaras() {
        return camaraRepository.findAll();
    }

    public void addNewCamara(Camara camara) {
        Optional<Camara> camaraByNumSerie = camaraRepository.findCamaraByNumSerie(camara.getNrSerie());

        if (camaraByNumSerie.isPresent()) {
            throw new IllegalStateException("Ja existe uma Camra com esse Número de Série!");
        }

        camaraRepository.save(camara);
    }

    public void deleteCamara(Long id) {
        boolean bool = camaraRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma Camara com esse Id"));

        }

        camaraRepository.deleteById(id);
    }

    @Transactional
    public void uptadeCamara(Long id, Camara camara) {
        Camara existingCamara = camaraRepository.findById(id).orElseThrow(() -> new IllegalStateException("Camara not found"));


        existingCamara.setEstado(camara.getEstado());


    }

    public Camara getCamaraById(Long id) {
        Camara existCamara = camaraRepository.findById(id).orElseThrow(() -> new IllegalStateException("Camara not found"));


        return existCamara;

    }
}
