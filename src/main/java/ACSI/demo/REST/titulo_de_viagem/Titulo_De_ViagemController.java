package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.camara.CamaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/titulodeviagem")
public class Titulo_De_ViagemController {
    private final Titulo_De_ViagemService titulo_de_viagemService;

    @Autowired
    public Titulo_De_ViagemController(Titulo_De_ViagemService titulo_de_viagemService) {
        this.titulo_de_viagemService = titulo_de_viagemService;
    }

    @GetMapping(path = "{titulodeviagemId}")
    public Titulo_De_Viagem getTitulodeViagemById(@PathVariable("titulodeviagemId") Long id) {
        return titulo_de_viagemService.getTitulodeViagemById(id);
    }

    @GetMapping
    public List<Titulo_De_Viagem> getTitulosdeViagem() {
        return titulo_de_viagemService.getTitulosdeViagem();
    }

    @PostMapping
    public void registarNewTitulodeViagem(@RequestBody Titulo_De_Viagem titulo_de_viagem) {
        titulo_de_viagemService.addNewTitulodeViagem(titulo_de_viagem);
    }

    @DeleteMapping(path = "{titulodeviagemId}")
    public void deleteTitulodeViagem(@PathVariable("titulodeviagemId") Long id) {
        titulo_de_viagemService.deleteTitulodeViagem(id);
    }

    @PutMapping(path = "{titulodeviagemId}")
    public void updateTitulodeViagem(@PathVariable("titulodeviagemId") Long id, @RequestBody Titulo_De_Viagem titulo_de_viagem) {
        titulo_de_viagemService.uptadeTitulodeViagem(id, titulo_de_viagem);
    }
}
