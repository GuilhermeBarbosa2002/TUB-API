package ACSI.demo.REST.movimento;

import ACSI.demo.REST.paragem.Paragem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/movimento")
public class MovimentoController {

    private final MovimentoService movimentoService;

    @Autowired
    public MovimentoController(MovimentoService movimentoService) {
        this.movimentoService = movimentoService;
    }

    @GetMapping(path = "{movimentoId}")
    public Movimento getMovimentoById(@PathVariable("movimentoId") Long id) {
        return movimentoService.getMovimentoById(id);
    }

    @GetMapping
    public List<Movimento> getMovimentos() {
        return movimentoService.getMovimentos();
    }

    @PostMapping
    public void registarNewMovimento(@RequestBody MovimentoCamara movimentoCamara) {
        movimentoService.addNewMovimento(movimentoCamara);
    }

    @DeleteMapping(path = "{movimentoId}")
    public void deleteMovimento(@PathVariable("movimentoId") Long id) {
        movimentoService.deleteMovimento(id);
    }

    @PutMapping(path = "{movimentoId}")
    public void updateMovimento(@PathVariable("movimentoId") Long id, @RequestBody Movimento movimento) {
        movimentoService.uptadeMovimento(id, movimento);
    }
}
