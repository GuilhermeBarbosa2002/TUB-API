package ACSI.demo.REST.paragem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/paragem")
public class ParagemController {
    private final ParagemService paragemService;

    @Autowired
    public ParagemController(ParagemService paragemService) {
        this.paragemService = paragemService;
    }

    @GetMapping(path = "{paragemId}")
    public Paragem getParagemById(@PathVariable("paragemId") Long id) {
        return paragemService.getParagemById(id);
    }

    @GetMapping
    public List<Paragem> getParagens() {
        return paragemService.getParagens();
    }

    @PostMapping
    public void registarNewBrt(@RequestBody Paragem paragem) {
        paragemService.addNewParagem(paragem);
    }

    @DeleteMapping(path = "{paragemId}")
    public void deleteParagem(@PathVariable("paragemId") Long id) {
        paragemService.deleteParagem(id);
    }

    @PutMapping(path = "{paragemId}")
    public void updateParagem(@PathVariable("paragemId") Long id, @RequestBody Paragem paragem) {
        paragemService.uptadeParagem(id, paragem);
    }

}
