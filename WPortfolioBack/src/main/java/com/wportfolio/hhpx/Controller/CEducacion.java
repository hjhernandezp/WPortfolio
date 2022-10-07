package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DEducacion;
import com.wportfolio.hhpx.Entity.Educacion;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion serEducacion;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = serEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Educacion entEducacion = serEducacion.getOne(id).get();
        return new ResponseEntity(entEducacion, HttpStatus.OK);
    }
    
    //CREACIOON (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DEducacion dtoEducacion) {
        
        //VERIFICACIONES
         if(serEducacion.existsByEduCarrera(dtoEducacion.getEduCarrera())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Educación"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Educacion entEducacion = new Educacion(
                dtoEducacion.getEduCarrera(), 
                dtoEducacion.getEduMencion(), 
                dtoEducacion.getEduEstado(),
                dtoEducacion.getEduInstituto(),
                dtoEducacion.getEduLugar()
        );
        
        //INCORPORACION
        serEducacion.save(entEducacion);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Educación"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DEducacion dtoEducacion) {
        
        //VERIFICACIONES
        if(!serEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serEducacion.existsByEduCarrera(dtoEducacion.getEduCarrera()) && serEducacion.getByEduCarrera(dtoEducacion.getEduCarrera()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Educación"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getEduLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Educacion entEducacion = serEducacion.getOne(id).get();
        entEducacion.setEduCarrera(dtoEducacion.getEduCarrera());
        entEducacion.setEduMencion(dtoEducacion.getEduMencion());
        entEducacion.setEduEstado(dtoEducacion.getEduEstado());
        entEducacion.setEduInstituto(dtoEducacion.getEduInstituto());
        entEducacion.setEduLugar(dtoEducacion.getEduLugar());
        
        //ACTUALIZACION
        serEducacion.save(entEducacion);
        return new ResponseEntity(new Mensaje("Registro actualizado: Educación"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.BAD_REQUEST);
        }
        
        //ELIMINACION
        serEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado de: Educación"), HttpStatus.OK);
    }
    
}
