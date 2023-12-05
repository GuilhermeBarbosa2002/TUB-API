package ACSI.demo.REST.movimento;

import ACSI.demo.PipesAndFilters.KafkaListeners;
import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.brt.BrtRepository;
import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraRepository;
import ACSI.demo.REST.paragem.Paragem;
import ACSI.demo.REST.paragem.ParagemRepository;
import ACSI.demo.REST.viagem.EstadoViagem;
import ACSI.demo.REST.viagem.Viagem;
import ACSI.demo.REST.viagem.ViagemRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService {

    private final MovimentoRepository movimentoRepository;
    private final CamaraRepository camaraRepository;

    private final BrtRepository brtRepository;

    private final ViagemRepository viagemRepository;
    @Autowired
    public MovimentoService(MovimentoRepository movimentoRepository, CamaraRepository camaraRepository, BrtRepository brtRepository,ViagemRepository viagemRepository ) {
        this.movimentoRepository = movimentoRepository;
        this.camaraRepository = camaraRepository;
        this.brtRepository = brtRepository;
        this.viagemRepository = viagemRepository;
    }

    public List<Movimento> getMovimentos() {
        return movimentoRepository.findAll();
    }

    @Transactional
    public void addNewMovimento(MovimentoCamara movimentoCamara) {
        Long camara_id = movimentoCamara.getId_camera();

        Camara existingCamara = camaraRepository.findById(camara_id).orElseThrow(() -> new IllegalStateException("Camara not found"));

        Brt brt = brtRepository.findBrtByCamera(camara_id).orElseThrow(() -> new IllegalStateException("A Camara não está em nenhum BRT"));

        System.out.println("\n \n\n\n\n " + brt.getMatricula() + " \n \\n\\n\\n\\n");
        EstadoViagem estadoViagem = EstadoViagem.EM_VIAGEM;

        Viagem viagem = viagemRepository.findViagemByBrt(brt.getId(), estadoViagem).orElseThrow(() -> new IllegalStateException("O brt não está em Viagem"));

        System.out.println("\n \n\n\n\n " + viagem.getRota().getNome() + " \n \\n\\n\\n\\n");

        String latitudeBrt= brt.getLatitude();
        String longitudeBrt = brt.getLongitude();

      String latitudeBrtSumarizada = latitudeBrt.substring(0, Math.min(latitudeBrt.length(), 8));
      String longitudeBrtSumarizada = longitudeBrt.substring(0, Math.min(longitudeBrt.length(), 8));


        for (Paragem p: viagem.getRota().getParagens()) {
            String latitudeParagem = p.getLatitude();
            String longitudeParagem = p.getLongitude();

            String latitudeParagemSumarizada = latitudeParagem.substring(0, Math.min(latitudeParagem.length(), 8));
            String longitudeParagemSumarizada = longitudeParagem.substring(0, Math.min(longitudeParagem.length(), 8));

            System.out.println("Latitude : " + latitudeBrtSumarizada + " --- "  +latitudeParagemSumarizada);
            System.out.println("Longitude : "  + longitudeParagemSumarizada + " --- "  +longitudeParagemSumarizada);
            if(latitudeBrtSumarizada.equalsIgnoreCase(latitudeParagemSumarizada) && longitudeBrtSumarizada.equalsIgnoreCase(longitudeParagemSumarizada)){
                Movimento movimento = new Movimento(p,movimentoCamara.getEntradaPassageiros(), movimentoCamara.getSaidaPassageiros(),movimentoCamara.getTempoParagem());
                movimentoRepository.save(movimento);
                viagem.getMovimentos().add(movimento);

                viagem.setAtualPessoas(viagem.getAtualPessoas() + movimento.getEntradaPassageiros());
                viagem.setAtualPessoas(viagem.getAtualPessoas() - movimento.getSaidaPassageiros());

                viagem.setTotalPessoas(viagem.getTotalPessoas() + movimento.getEntradaPassageiros());
                return;
            }


        }
        throw new IllegalStateException("Paragem não encontrada");
    }

    public void deleteMovimento(Long id) {
        boolean bool = movimentoRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Não existe nenhum Movimento com esse Id"));

        }

        movimentoRepository.deleteById(id);
    }
    @Transactional
    public void uptadeMovimento(Long id, Movimento movimento) {
        Movimento existingMovimento = movimentoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Movimento not found"));

        existingMovimento.setParagem(movimento.getParagem());
        existingMovimento.setEntradaPassageiros(movimento.getEntradaPassageiros());
        existingMovimento.setSaidaPassageiros(movimento.getSaidaPassageiros());
        existingMovimento.setTempoParagem(movimento.getTempoParagem());
    }

    public Movimento getMovimentoById(Long id) {
        Movimento existingMovimento = movimentoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Movimento not found"));
        return existingMovimento;

    }


}
