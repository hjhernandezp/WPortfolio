package com.wportfolio.hhpx.Dto;

import javax.validation.constraints.NotBlank;

public class DCursos {
    @NotBlank
    private String curNombre;
    @NotBlank
    private String curInstituto;
    @NotBlank
    private String curLugar;
    @NotBlank
    private int curHoras;
    
    //CONSTRUCTOR
    public DCursos() {
    }

    public DCursos(
            String curNombre,
            String curInstituto,
            String curLugar,
            int curHoras
    ) {
        this.curNombre = curNombre;
        this.curInstituto = curInstituto;
        this.curLugar = curLugar;
        this.curHoras = curHoras;
    }
    
    //GETTERS & SETTES
    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public String getCurInstituto() {
        return curInstituto;
    }

    public void setCurInstituto(String curInstituto) {
        this.curInstituto = curInstituto;
    }

    public String getCurLugar() {
        return curLugar;
    }

    public void setCurLugar(String curLugar) {
        this.curLugar = curLugar;
    }

    public int getCurHoras() {
        return curHoras;
    }

    public void setCurHoras(int curHoras) {
        this.curHoras = curHoras;
    }

}
