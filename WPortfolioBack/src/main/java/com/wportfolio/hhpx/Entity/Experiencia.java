package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expEmpresa;
    private String expLugar;
    private String expCargo;

    //CONSTRUCTOR
    public Experiencia() {
    }

    public Experiencia(
            String expEmpresa,
            String expLugar,
            String expCargo
    ) {
        this.expEmpresa = expEmpresa;
        this.expLugar = expLugar;
        this.expCargo = expCargo;
    }
    
    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
