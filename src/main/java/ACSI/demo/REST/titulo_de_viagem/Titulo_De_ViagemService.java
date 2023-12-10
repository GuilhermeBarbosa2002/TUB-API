package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Titulo_De_ViagemService {
    private final Titulo_De_ViagemRepository titulo_de_viagemRepository;

    @Autowired
    public Titulo_De_ViagemService(Titulo_De_ViagemRepository titulo_de_viagemRepository) {
        this.titulo_de_viagemRepository = titulo_de_viagemRepository;
    }

    public List<Titulo_De_Viagem> getTitulosdeViagem() {
        return titulo_de_viagemRepository.findAll();
    }

    public void addNewTitulodeViagem(Titulo_De_Viagem titulo_de_viagem) {
        Optional<Titulo_De_Viagem> titulo_de_viagembyid = titulo_de_viagemRepository.findTitulodeViagemById(titulo_de_viagem.getId());

        if (titulo_de_viagembyid.isPresent()) {
            throw new IllegalStateException("Ja existe um titulode viagem com esse Id!");
        }
        titulo_de_viagemRepository.save(titulo_de_viagem);
    }

    public void deleteTitulodeViagem(Long id) {
        boolean bool = titulo_de_viagemRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum Titulo de viagem com esse Id"));

        }
        titulo_de_viagemRepository.deleteById(id);
    }

    @Transactional
    public void uptadeTitulodeViagem(Long id, Titulo_De_Viagem titulo_de_viagem) {
        Titulo_De_Viagem  existingTitulodeViagem = titulo_de_viagemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Titulo de Viagem not found"));
        existingTitulodeViagem.setValidado(true);
    }

    public Titulo_De_Viagem getTitulodeViagemById(Long id) {
        Titulo_De_Viagem existingTitulodeViagem = titulo_de_viagemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Titulo de Viagem not found"));
        return existingTitulodeViagem;
    }
}