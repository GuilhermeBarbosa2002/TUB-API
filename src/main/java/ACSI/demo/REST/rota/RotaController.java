package ACSI.demo.REST.rota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/rota")
public class RotaController {
    private final RotaService rotaService;

    @Autowired
    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @GetMapping
    public List<Rota> getRotas() {
        return rotaService.getRotas();
    }

    @PostMapping
    public void registarNovaRota(@RequestBody Rota rota) {
        rotaService.addNovaRota(rota);
    }

    @DeleteMapping(path = "{rotaId}")
    public void deleteRota(@PathVariable("rotaId") Long id) {
        rotaService.deleteRota(id);
    }

    @PutMapping(path = "{rotaId}")
    public void updateRota(@PathVariable("rotaId") Long id, @RequestBody Rota rota) {
        rotaService.uptadeRota(id, rota);
    }
}
