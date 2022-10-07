package com.wportfolio.hhpx.Dto;

import javax.validation.constraints.NotBlank;

public class DEducacion {
    @NotBlank
    private String eduCarrera;
    @NotBlank
    private String eduMencion;
    @NotBlank
    private String eduEstado;
    @NotBlank
    private String eduInstituto;
    @NotBlank
    private String eduLugar;
    
    //Constructores
    public DEducacion() {
    }

    public DEducacion(
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
