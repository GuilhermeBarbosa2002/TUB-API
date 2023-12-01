package ACSI.demo.REST.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {
    private final ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    public void addNewViagem(Viagem viagem) {
        Optional<Viagem> viagemById = viagemRepository.findViagemById(viagem.getId());

        if (viagemById.isPresent()) {
            throw new IllegalStateException("Ja existe uma Viagem com esse id!");
        }

        viagemRepository.save(viagem);
    }

    public void deleteViagem(Long id) {
        boolean bool = viagemRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma Viagem com esse Id"));

        }

        viagemRepository.deleteById(id);
    }

    public void uptadeViagem(Long id, Viagem viagem) {
        Viagem existingViagem = viagemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Viagem not found"));

        existingViagem.setMotorista(viagem.getMotorista());
        existingViagem.setRota(viagem.getRota());
        existingViagem.setData(viagem.getData());
        existingViagem.setEstado(viagem.getEstado());
        existingViagem.setBrt(viagem.getBrt());
    }

    public Viagem getViagemById(Long id) {
        Viagem existingViagem = viagemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Viagem not found"));


        return existingViagem;

    }
}
