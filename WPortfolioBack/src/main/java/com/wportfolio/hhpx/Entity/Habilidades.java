package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidades {
    //HAB -> Habilidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String habNombre;
    private int habNivel;
    
    //CONSTRUCTOR
    public Habilidades() {
    }

    public Habilidades(String habNombre, int habNivel) {
        this.habNombre = habNombre;
        this.habNivel = habNivel;
    }
    
    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabNombre() {
        return habNombre;
    }

    public void setHabNombre(String habNombre) {
        this.habNombre = habNombre;
    }

    public int getHabNivel() {
        return habNivel;
    }

    public void setHabNivel(int habNivel) {
        this.habNivel = habNivel;
    }

}
