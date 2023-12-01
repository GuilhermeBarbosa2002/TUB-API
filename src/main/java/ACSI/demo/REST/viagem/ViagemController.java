package ACSI.demo.REST.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/viagem")
public class ViagemController {
    private final ViagemService viagemService;

    @Autowired
    public ViagemController(ViagemService viagemService) {
        this.viagemService = viagemService;
    }

    @GetMapping(path = "{paragemId}")
    public Viagem getViagemById(@PathVariable("paragemId") Long id) {
        return viagemService.getViagemById(id);
    }

    @GetMapping
    public List<Viagem> getViagens() {
        return viagemService.getViagens();
    }

    @PostMapping
    public void registarNewViagem(@RequestBody Viagem viagem) {
        viagemService.addNewViagem(viagem);
    }

    @DeleteMapping(path = "{viagemId}")
    public void deleteViagem(@PathVariable("viagemId") Long id) {
        viagemService.deleteViagem(id);
    }

    @PutMapping(path = "{viagemId}")
    public void updateViagem(@PathVariable("viagemId") Long id, @RequestBody Viagem viagem) {
        viagemService.uptadeViagem(id, viagem);
    }

}
