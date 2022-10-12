package com.wportfolio.hhpx.Dto;

import javax.validation.constraints.NotBlank;

public class DExperiencia {
    @NotBlank
    private String expEmpresa;
    @NotBlank
    private String expLugar;
    @NotBlank
    private String expCargo;
    
    //CONSTRUCTOR
    public DExperiencia() {
    }

    public DExperiencia(
            String expEmpresa, 
            String expLugar, 
            String expCargo
    ) {
        this.expEmpresa = expEmpresa;
        this.expLugar = expLugar;
        this.expCargo = expCargo;
    }
    
    //GETTERES & SETTERS
    public String getExpEmpresa() {
        return expEmpresa;
    }

    public void setExpEmpresa(String expEmpresa) {
        this.expEmpresa = expEmpresa;
    }

    public String getExpLugar() {
        return expLugar;
    }

    public void setExpLugar(String expLugar) {
        this.expLugar = expLugar;
    }

    public String getExpCargo() {
        return expCargo;
    }

    public void setExpCargo(String expCargo) {
        this.expCargo = expCargo;
    }
    
}
