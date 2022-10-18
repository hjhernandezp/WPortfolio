package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DCursos;
import com.wportfolio.hhpx.Entity.Cursos;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SCursos;
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
@RequestMapping("/cursos")
@CrossOrigin(origins = {"http://localhost:4200", "https://webportfolio-nl1014.web.app"})
public class CCursos {
    @Autowired
    SCursos serCursos;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list() {
        List<Cursos> list = serCursos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Cursos entCursos = serCursos.getOne(id).get();
        return new ResponseEntity(entCursos, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DCursos dtoCursos) {
        
        //VERIFICACIONES
         if(serCursos.existsByCurNombre(dtoCursos.getCurNombre())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Cursos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoCursos.getCurNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoCursos.getCurInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoCursos.getCurLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(dtoCursos.getCurHoras() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Horas"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Cursos entCursos = new Cursos(
                dtoCursos.getCurNombre(), 
                dtoCursos.getCurInstituto(), 
                dtoCursos.getCurLugar(),
                dtoCursos.getCurHoras()
        );
        
        //INCORPORACION
        serCursos.save(entCursos);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Cursos"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DCursos dtoCursos) {
        
        //VERIFICACIONES
        if(!serCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serCursos.existsByCurNombre(dtoCursos.getCurNombre()) && serCursos.getByCurNombre(dtoCursos.getCurNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Cursos"), HttpStatus.BAD_REQUEST);            
        }

        if(StringUtils.isBlank(dtoCursos.getCurNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoCursos.getCurInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoCursos.getCurLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(dtoCursos.getCurHoras() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Horas"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Cursos entCursos = serCursos.getOne(id).get();
        entCursos.setCurNombre(dtoCursos.getCurNombre());
        entCursos.setCurInstituto(dtoCursos.getCurInstituto());
        entCursos.setCurLugar(dtoCursos.getCurLugar());
        entCursos.setCurHoras(dtoCursos.getCurHoras());
        
        //ACTUALIZACION
        serCursos.save(entCursos);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Cursos"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        serCursos.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Cursos"), HttpStatus.OK);
    }
}
