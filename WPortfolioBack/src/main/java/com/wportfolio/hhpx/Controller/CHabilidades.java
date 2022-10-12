package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DHabilidades;
import com.wportfolio.hhpx.Entity.Habilidades;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SHabilidades;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("habilidades")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidades {
    @Autowired
    SHabilidades serHabilidades;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = serHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Habilidades entHabilidades = serHabilidades.getOne(id).get();
        return new ResponseEntity(entHabilidades, HttpStatus.OK);
    }

    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DHabilidades dtoHabilidades) {
        
        //VERIFICACIONES
         if(serHabilidades.existsByHabNombre(dtoHabilidades.getHabNombre())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Habilidades"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoHabilidades.getHabNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(dtoHabilidades.getHabNivel() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nivel"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Habilidades entHabilidades = new Habilidades(
                dtoHabilidades.getHabNombre(), 
                dtoHabilidades.getHabNivel()
        );
        
        //INCORPORACION
        serHabilidades.save(entHabilidades);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Habilidades"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DHabilidades dtoHabilidades) {
        
        //VERIFICACIONES
        if(!serHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serHabilidades.existsByHabNombre(dtoHabilidades.getHabNombre()) && serHabilidades.getByHabNombre(dtoHabilidades.getHabNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Habilidades"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(dtoHabilidades.getHabNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(dtoHabilidades.getHabNivel() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nivel"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Habilidades entHabilidades = serHabilidades.getOne(id).get();
        entHabilidades.setHabNombre(dtoHabilidades.getHabNombre());
        entHabilidades.setHabNivel(dtoHabilidades.getHabNivel());
        
        //ACTUALIZACION
        serHabilidades.save(entHabilidades);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Habilidades"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        serHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Cursos"), HttpStatus.OK);
    }

}
