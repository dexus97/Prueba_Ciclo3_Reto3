package com.usa.ciclo3.prueba_ciclo3_reto3.controller;


import com.usa.ciclo3.prueba_ciclo3_reto3.model.Client;
import com.usa.ciclo3.prueba_ciclo3_reto3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Client> getAll(){return clienteService.getAll();}

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){return clienteService.getClient(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){return clienteService.save(client);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){return clienteService.update(client);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id")int id){
        return clienteService.deleteClient(id);
    }
}
