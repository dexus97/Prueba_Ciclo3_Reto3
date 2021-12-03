package com.usa.ciclo3.prueba_ciclo3_reto3.service;

import com.usa.ciclo3.prueba_ciclo3_reto3.model.Skate;
import com.usa.ciclo3.prueba_ciclo3_reto3.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate skate){
        if(skate.getId()==null){
            return skateRepository.save(skate);
        }else{
            Optional<Skate> tmpSkate = skateRepository.getSkate(skate.getId());
            if (tmpSkate.isEmpty()){
                return skateRepository.save(skate);
            }else{
                return skate;
            }
        }
    }
    public Skate update(Skate skate){
        if(skate.getId()!=null){
            Optional<Skate> e=skateRepository.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand()); ;
                }
                if(skate.getBrand() !=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                skateRepository.save(e.get());
                return e.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }

    public boolean deleteSkate(int id){
        Boolean aBoolean = getSkate(id).map(skate -> {
            skateRepository.delete(skate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
