package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    //EDU -> EDUCACION
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eduCarrera;
    private String eduMencion;
    private String eduEstado;
    private String eduInstituto;
    private String eduLugar;
   
    //Constructor
    public Educacion() {
    }

    public Educacion(
            String eduCarrera, 
            String eduMencion, 
            String eduEstado, 
            String eduInstituto, 
            String eduLugar
    ) {
        this.eduCarrera = eduCarrera;
        this.eduMencion = eduMencion;
        this.eduEstado = eduEstado;
        this.eduInstituto = eduInstituto;
        this.eduLugar = eduLugar;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEduCarrera() {
        return eduCarrera;
    }

    public void setEduCarrera(String eduCarrera) {
        this.eduCarrera = eduCarrera;
    }

    public String getEduMencion() {
        return eduMencion;
    }

    public void setEduMencion(String eduMencion) {
        this.eduMencion = eduMencion;
    }

    public String getEduEstado() {
        return eduEstado;
    }

    public void setEduEstado(String eduEstado) {
        this.eduEstado = eduEstado;
    }

    public String getEduInstituto() {
        return eduInstituto;
    }

    public void setEduInstituto(String eduInstituto) {
        this.eduInstituto = eduInstituto;
    }

    public String getEduLugar() {
        return eduLugar;
    }

    public void setEduLugar(String eduLugar) {
        this.eduLugar = eduLugar;
    }
    
}
