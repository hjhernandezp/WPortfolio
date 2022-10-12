package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudios {
    
    //EST -> ESTUDIOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estCarrera;
    private String estMencion;
    private String estEstado;
    private String estInstituto;
    private String estLugar;
   
    //Constructor
    public Estudios() {
    }

    public Estudios(
            String eduCarrera, 
            String eduMencion, 
            String eduEstado, 
            String eduInstituto, 
            String eduLugar
    ) {
        this.estCarrera = eduCarrera;
        this.estMencion = eduMencion;
        this.estEstado = eduEstado;
        this.estInstituto = eduInstituto;
        this.estLugar = eduLugar;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstCarrera() {
        return estCarrera;
    }

    public void setEstCarrera(String estCarrera) {
        this.estCarrera = estCarrera;
    }

    public String getEstMencion() {
        return estMencion;
    }

    public void setEstMencion(String estMencion) {
        this.estMencion = estMencion;
    }

    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
    }

    public String getEstInstituto() {
        return estInstituto;
    }

    public void setEstInstituto(String estInstituto) {
        this.estInstituto = estInstituto;
    }

    public String getEstLugar() {
        return estLugar;
    }

    public void setEstLugar(String estLugar) {
        this.estLugar = estLugar;
    }
    
}
