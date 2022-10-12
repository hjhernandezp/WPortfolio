package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DEstudios;
import com.wportfolio.hhpx.Entity.Estudios;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SEstudios;
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
@RequestMapping("estudios")
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudios {
    @Autowired
    SEstudios serEstudios;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list() {
        List<Estudios> list = serEstudios.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Estudios entEstudios = serEstudios.getOne(id).get();
        return new ResponseEntity(entEstudios, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DEstudios dtoEstudios) {
        
        //VERIFICACIONES
         if(serEstudios.existsByEstCarrera(dtoEstudios.getEstCarrera())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Estudios"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Estudios entEstudios = new Estudios(
                dtoEstudios.getEstCarrera(), 
                dtoEstudios.getEstMencion(), 
                dtoEstudios.getEstEstado(),
                dtoEstudios.getEstInstituto(),
                dtoEstudios.getEstLugar()
        );
        
        //INCORPORACION
        serEstudios.save(entEstudios);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Estudios"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DEstudios dtoEstudios) {
        
        //VERIFICACIONES
        if(!serEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serEstudios.existsByEstCarrera(dtoEstudios.getEstCarrera()) && serEstudios.getByEstCarrera(dtoEstudios.getEstCarrera()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Estudios"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEstudios.getEstLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Estudios entEstudios = serEstudios.getOne(id).get();
        entEstudios.setEstCarrera(dtoEstudios.getEstCarrera());
        entEstudios.setEstMencion(dtoEstudios.getEstMencion());
        entEstudios.setEstEstado(dtoEstudios.getEstEstado());
        entEstudios.setEstInstituto(dtoEstudios.getEstInstituto());
        entEstudios.setEstLugar(dtoEstudios.getEstLugar());
        
        //ACTUALIZACION
        serEstudios.save(entEstudios);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Estudios"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        serEstudios.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Estudios"), HttpStatus.OK);
    }
    
}
