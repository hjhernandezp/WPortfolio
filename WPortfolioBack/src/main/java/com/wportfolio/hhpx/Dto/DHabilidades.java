package com.wportfolio.hhpx.Dto;

import javax.validation.constraints.NotBlank;

public class DHabilidades {
    @NotBlank
    private String habNombre;
    @NotBlank
    private int habNivel;
    
    //CONSTRUCTOR
    public DHabilidades() {
    }

    public DHabilidades(
            String habNombre, 
            int habNivel
    ) {
        this.habNombre = habNombre;
        this.habNivel = habNivel;
    }
    
    //GETTERS & SETTERS
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

    /*NO SÉ NI CÓMO NI CUANDO APARECIÓ ESTO, COMENTADO PROVISIONALMENTE, LUEGO BORRAR
    public CharSequence getCurInstituto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */
}
