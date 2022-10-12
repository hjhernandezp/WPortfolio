package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cursos {
    //CUR -> CURSOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String curNombre;
    private String curInstituto;
    private String curLugar;
    private int curHoras;
    
    //CONSTRUCTOR
    public Cursos() {
    }

    public Cursos(
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
    
    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
