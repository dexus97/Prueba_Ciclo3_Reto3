package com.usa.ciclo3.prueba_ciclo3_reto3.crudrepository;

import com.usa.ciclo3.prueba_ciclo3_reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
