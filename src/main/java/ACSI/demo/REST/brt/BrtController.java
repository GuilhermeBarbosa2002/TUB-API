package ACSI.demo.REST.brt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/brt")
public class BrtController {
    private final  BrtService brtService;

@Autowired
    public BrtController(BrtService brtService) {
        this.brtService = brtService;
    }

    @GetMapping(path = "{brtId}")
    public Brt getBrtById(@PathVariable("brtId") Long id) {
        return brtService.getBrtById(id);
    }


    @GetMapping
 public List<Brt> getBrts(){
   return brtService.getBrts();
 }

 @PostMapping
 public void registarNewBrt(@RequestBody Brt brt){
    brtService.addNewBrt(brt);
 }
    @DeleteMapping(path = "{brtId}")
    public void deleteStudent(@PathVariable ("brtId") Long id){
        brtService.deleteBrt(id);
    }
    @PutMapping(path = "{brtId}")
    public void updateStudent(@PathVariable("brtId")Long id, @RequestBody Brt brt){
        brtService.uptadeBrt(id,brt);
    }

}
