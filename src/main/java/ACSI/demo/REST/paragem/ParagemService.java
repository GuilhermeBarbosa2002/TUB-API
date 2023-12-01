package ACSI.demo.REST.paragem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParagemService {
    private final ParagemRepository paragemRepository;

    @Autowired
    public ParagemService(ParagemRepository paragemRepository) {
        this.paragemRepository = paragemRepository;
    }

    public List<Paragem> getParagens() {
        return paragemRepository.findAll();
    }

    public void addNewParagem(Paragem paragem) {
        Optional<Paragem> paragemByNome = paragemRepository.findParagemByNome(paragem.getNome());

        if (paragemByNome.isPresent()) {
            throw new IllegalStateException("Ja existe uma Paragem com esse nome!");
        }

        paragemRepository.save(paragem);
    }

    public void deleteParagem(Long id) {
        boolean bool = paragemRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhuma Paragem com esse Id"));

        }

        paragemRepository.deleteById(id);
    }

    public void uptadeParagem(Long id, Paragem paragem) {
        Paragem existingParagem = paragemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Paragem not found"));

        existingParagem.setNome(paragem.getNome());
        existingParagem.setLatitude(paragem.getLatitude());
        existingParagem.setLongitude(paragem.getLongitude());
    }

    public Paragem getParagemById(Long id) {
        Paragem existingParagem = paragemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Paragem not found"));


        return existingParagem;

    }
}
