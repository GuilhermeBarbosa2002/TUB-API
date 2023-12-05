package ACSI.demo.REST.brt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BrtService {
    private final BrtRepository brtRepository;

    @Autowired
    public BrtService(BrtRepository brtRepository) {
        this.brtRepository = brtRepository;
    }

    public List<Brt> getBrts(){
        return brtRepository.findAll();
    }

    public void addNewBrt(Brt brt){
        Optional<Brt> btrByMatricula = brtRepository.findBrtByMatricula(brt.getMatricula());

        if(btrByMatricula.isPresent()){
            throw new IllegalStateException("Ja existe um BRT com a mesma matricula");
        }

        if(!isMatriculaRegex(brt.getMatricula())){
            throw new IllegalStateException("Formato de matricula inválido!");

        }

        brtRepository.save(brt);
    }

    public void deleteBrt(Long id){
        boolean bool = brtRepository.existsById(id);

        if(!bool){
            throw new IllegalStateException(("Não existe nenhum BRT com esse Id"));

        }

        brtRepository.deleteById(id);

    }

    @Transactional
    public void uptadeBrt(Long id,Brt brt){

        Brt existingBRT = brtRepository.findById(id).orElseThrow(() -> new IllegalStateException("BRT not found"));

        if(!brt.getMatricula().equals(existingBRT.getMatricula())){
            throw new IllegalStateException(("Não podes alterar a matricula!"));
        }
        if(!brt.getDataRegisto().equals(existingBRT.getDataRegisto())){
            throw new IllegalStateException(("Não podes alterar a data de Registo!"));
        }

        existingBRT.setCapacidade(brt.getCapacidade());

    }

    public boolean isMatriculaRegex(String matricula) {
        // pattern:
        // \A                                    - início da string
        //    (    \d{2}\-\d{2}\-[A-Z]{2}        - NN-NN-XX
        //      || \d{2}\-[A-Z]{2}\-\d{2}        - NN-XX-NN
        //      || [A-Z]{2}\-\d{2}\-\d{2} )      - XX-NN-NN
        //                                  \z   - fim da string
        Pattern pattern = Pattern.compile("^(\\d{2}-\\d{2}-[A-Z]{2}|\\d{2}-[A-Z]{2}-\\d{2}|[A-Z]{2}-\\d{2}-\\d{2}|\\d{2}[A-Z]{2}\\d{2})$");
        Matcher matcher =  pattern.matcher(matricula);
        return matcher.find();
    }

    public Brt getBrtById(Long id) {
        Brt existBrt = brtRepository.findById(id).orElseThrow(() -> new IllegalStateException("brt not found"));


        return existBrt;

    }

    @Transactional
    public void updateLocalizacao(Long id, String latitude, String longitude){
        System.out.println("---------------------------   " + id + "--------------");
        Brt existingBRT = brtRepository.findById(id).orElseThrow(() -> new IllegalStateException("BRT not found"));

        existingBRT.setLatitude(latitude);
        existingBRT.setLongitude(longitude);

    }
}
