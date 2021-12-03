package com.usa.ciclo3.prueba_ciclo3_reto3.controller;

import com.usa.ciclo3.prueba_ciclo3_reto3.model.Skate;
import com.usa.ciclo3.prueba_ciclo3_reto3.service.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SkateController {
    @Autowired
    private SkateService skateService;

    @GetMapping("/all")
    public List<Skate> getAll(){return skateService.getAll();}

    @GetMapping("/{id}")
    public Optional<Skate> getCabin(@PathVariable("id") int id){return skateService.getSkate(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate){ return skateService.save(skate);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate){
        return skateService.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){return skateService.deleteSkate(id);}
}
