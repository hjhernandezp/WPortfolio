package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DExperiencia;
import com.wportfolio.hhpx.Entity.Experiencia;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SExperiencia;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia serExperiencia;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = serExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Experiencia entExperiencia = serExperiencia.getOne(id).get();
        return new ResponseEntity(entExperiencia, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DExperiencia dtoExperiencia) {
        
        //VERIFICACIONES
         if(serExperiencia.existsByExpEmpresa(dtoExperiencia.getExpEmpresa())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Experiencia"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperiencia.getExpEmpresa())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Empresa"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperiencia.getExpLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperiencia.getExpCargo())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Cargo"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Experiencia entExperiencia = new Experiencia(
                dtoExperiencia.getExpEmpresa(), 
                dtoExperiencia.getExpLugar(),
                dtoExperiencia.getExpCargo()
        );
        
        //INCORPORACION
        serExperiencia.save(entExperiencia);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Experiencia"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DExperiencia dtoExperiencia) {
        
        //VERIFICACIONES
        if(!serExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serExperiencia.existsByExpEmpresa(dtoExperiencia.getExpEmpresa()) && serExperiencia.getByExpEmpresa(dtoExperiencia.getExpEmpresa()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Experiencia"), HttpStatus.BAD_REQUEST);            
        }

        if(StringUtils.isBlank(dtoExperiencia.getExpEmpresa())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Empresa"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperiencia.getExpLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperiencia.getExpCargo())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Cargo"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Experiencia entExperiencia = serExperiencia.getOne(id).get();
        entExperiencia.setExpEmpresa(dtoExperiencia.getExpEmpresa());
        entExperiencia.setExpLugar(dtoExperiencia.getExpLugar());
        entExperiencia.setExpCargo(dtoExperiencia.getExpCargo());
        
        //ACTUALIZACION
        serExperiencia.save(entExperiencia);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Experiencia"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        serExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Experiencia"), HttpStatus.OK);
    }

}
