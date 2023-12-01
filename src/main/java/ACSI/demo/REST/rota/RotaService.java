package ACSI.demo.REST.rota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {
    private final RotaRepository rotaRepository;

    @Autowired
    public RotaService(RotaRepository rotaRepository) {
        this.rotaRepository = rotaRepository;
    }

    public List<Rota> getRotas() {
        return rotaRepository.findAll();
    }

    public void addNovaRota(Rota rota) {
        rotaRepository.save(rota);
    }

    public void deleteRota(Long id) {
        rotaRepository.deleteById(id);
    }

    public void uptadeRota(Long id, Rota novaRota) {
        // Verificar se a rota com o ID existe
        if (rotaRepository.existsById(id)) {
            novaRota.setId(id);
            rotaRepository.save(novaRota);
        } else {
            // Lidar com a situação em que a rota com o ID não existe
            // Pode lançar uma exceção ou tomar outra ação apropriada
        }
    }
}
