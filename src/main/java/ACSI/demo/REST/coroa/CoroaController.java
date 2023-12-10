package ACSI.demo.REST.coroa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coroa")
public class CoroaController {
    private final CoroaService coroaService;

    @Autowired
    public CoroaController(CoroaService coroaService) {
        this.coroaService = coroaService;
    }

    @GetMapping(path = "{coroaId}")
    public Coroa getCoroaById(@PathVariable("coroaId") Long id) {
        return coroaService.getCoroaById(id);
    }

    @GetMapping
    public List<Coroa> getCoroas() {
        return coroaService.getCamaras();
    }

    @PostMapping
    public void registarNewCoroa(@RequestBody Coroa coroa) {
        coroaService.addNewCoroa(coroa);
    }

    @DeleteMapping(path = "{coroaId}")
    public void deleteCoroa(@PathVariable("coroaId") Long id) {
        coroaService.deleteCoroa(id);
    }

    @PutMapping(path = "{coroaId}")
    public void updateCoroa(@PathVariable("coroaId") Long id, @RequestBody Coroa coroa) {
        coroaService.uptadeCoroa(id, coroa);
    }

}
