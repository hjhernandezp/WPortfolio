package com.wportfolio.hhpx.Dto;

import javax.validation.constraints.NotBlank;

public class DEstudios {
    @NotBlank
    private String estCarrera;
    @NotBlank
    private String estMencion;
    @NotBlank
    private String estEstado;
    @NotBlank
    private String estInstituto;
    @NotBlank
    private String estLugar;
    
    //Constructor
    public DEstudios() {
    }

    public DEstudios(
            String estCarrera, 
            String estMencion, 
            String estEstado, 
            String estInstituto, 
            String estLugar
    ) {
        this.estCarrera = estCarrera;
        this.estMencion = estMencion;
        this.estEstado = estEstado;
        this.estInstituto = estInstituto;
        this.estLugar = estLugar;
    }

    //Getters & Setters
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
