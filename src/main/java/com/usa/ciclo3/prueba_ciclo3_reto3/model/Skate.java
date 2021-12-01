package com.usa.ciclo3.prueba_ciclo3_reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skate")
public class Skate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    private List<Reservation> reservations;

    public Integer getId(){
        return id;
    }
}
