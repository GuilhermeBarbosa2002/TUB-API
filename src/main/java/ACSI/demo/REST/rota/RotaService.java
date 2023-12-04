package ACSI.demo.REST.rota;

import ACSI.demo.REST.paragem.Paragem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Rota> rotaByNome = rotaRepository.findRotaByNome(rota.getNome());
        if (rotaByNome.isPresent()) {
            throw new IllegalStateException("Já existe uma rota com esse nome!");
        }
        rotaRepository.save(rota);
    }

    public void deleteRota(Long id) {
        boolean bool = rotaRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma Rota com esse Id"));

        }
        rotaRepository.deleteById(id);
    }
    @Transactional
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
    public Rota getRotaById(Long id) {
        Rota existingRota = rotaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Rota not found"));
        return existingRota;

    }
}
