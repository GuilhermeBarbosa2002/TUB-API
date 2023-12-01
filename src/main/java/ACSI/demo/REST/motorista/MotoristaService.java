package ACSI.demo.REST.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    private final MotoristaRepository motoristaRepository;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public void uptadeMotorista(Long id, Motorista motorista) {
        Motorista existingMotorista = motoristaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Motorista not found"));

        existingMotorista.setNome(motorista.getNome());
        existingMotorista.setEmail(motorista.getEmail());
        existingMotorista.setNumerocc(motorista.getNumerocc());
        existingMotorista.setTelefone(motorista.getTelefone());
        existingMotorista.setHorario(motorista.getHorario());
    }

    public void deleteMotorista(Long id) {
        boolean bool = motoristaRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum Motorista com esse Id"));

        }

        motoristaRepository.deleteById(id);
    }

    public void addNewMotorista(Motorista motorista) {
        Optional<Motorista> motoristaByNome = motoristaRepository.findMotoristaByNome(motorista.getNome());

        if (motoristaByNome.isPresent()) {
            throw new IllegalStateException("Ja existe um Motorista com esse nome!");
        }

        motoristaRepository.save(motorista);
    }

    public Motorista getMotoristaById(Long id) {
        Motorista existingMotorista = motoristaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Motorista not found"));

        return existingMotorista;
    }

    public List<Motorista> getMotorista() {
        return motoristaRepository.findAll();
    }
}
