package ACSI.demo.REST.camara;


import ACSI.demo.REST.paragem.CamaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/camara")
public class CamaraController {
    private final CamaraService camaraService;

    @Autowired
    public CamaraController(CamaraService camaraService) {
        this.camaraService = camaraService;
    }

    @GetMapping(path = "{camaraId}")
    public Camara getCamaraById(@PathVariable("camaraId") Long id) {
        return camaraService.getCamaraById(id);
    }

    @GetMapping
    public List<Camara> getCamaras() {
        return camaraService.getCamaras();
    }

    @PostMapping
    public void registarNewCamara(@RequestBody Camara camara) {
        camaraService.addNewCamara(camara);
    }

    @DeleteMapping(path = "{camaraId}")
    public void deleteCamara(@PathVariable("camaraId") Long id) {
        camaraService.deleteCamara(id);
    }

    @PutMapping(path = "{camaraId}")
    public void updateCamara(@PathVariable("camaraId") Long id, @RequestBody Camara camara) {
        camaraService.uptadeCamara(id, camara);
    }

}
