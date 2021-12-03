package com.usa.ciclo3.prueba_ciclo3_reto3.repository;


import com.usa.ciclo3.prueba_ciclo3_reto3.crudrepository.ClientCrudRespository;
import com.usa.ciclo3.prueba_ciclo3_reto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    public ClientCrudRespository clientCrudRespository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRespository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRespository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRespository.save(client);
    }

    public void delete(Client client){
        clientCrudRespository.delete(client);
    }

}
