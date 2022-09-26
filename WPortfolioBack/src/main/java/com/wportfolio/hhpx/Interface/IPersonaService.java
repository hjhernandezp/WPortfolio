package com.wportfolio.hhpx.Interface;

import com.wportfolio.hhpx.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer Lista de Personas
    public List<Persona> getPersona();
    
    //Guardar objeto tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto tipo Persona
    public void deletePersona(Long id);
    
    //Buscar Persona
    public Persona findPersona(Long id);
}
