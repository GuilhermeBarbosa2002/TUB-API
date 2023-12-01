package ACSI.demo.REST.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motorista")
public class MotoristaController {
    private final MotoristaService motoristaService;

    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping(path = "{paragemId}")
    public Motorista getMotoristaById(@PathVariable("motoristaId") Long id) {
        return motoristaService.getMotoristaById(id);
    }

    @GetMapping
    public List<Motorista> getMotorista() {
        return motoristaService.getMotorista();
    }

    @PostMapping
    public void registarNewMotorista(@RequestBody Motorista motorista) {
        motoristaService.addNewMotorista(motorista);
    }

    @DeleteMapping(path = "{motoristaId}")
    public void deleteMotorista(@PathVariable("motoristaId") Long id) {
        motoristaService.deleteMotorista(id);
    }

    @PutMapping(path = "{motoristaId}")
    public void updateMotorista(@PathVariable("motoristaId") Long id, @RequestBody Motorista motorista) {
        motoristaService.uptadeMotorista(id, motorista);
    }

}
