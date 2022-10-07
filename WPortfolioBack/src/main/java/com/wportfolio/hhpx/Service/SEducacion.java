package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Educacion;
import com.wportfolio.hhpx.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion repEducacion;
    
    public List<Educacion> list() {
        return repEducacion.findAll();
        
    }
    
    public Optional<Educacion> getOne(int id) {
        return repEducacion.findById(id);
    }
    
    public Optional<Educacion> getByEduCarrera(String eduCarrera) {
        return repEducacion.findByEduCarrera(eduCarrera);
    }
    
    public void save(Educacion entEducacion) {
        repEducacion.save(entEducacion);
    }
    
    public void delete(int id) {
        repEducacion.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return repEducacion.existsById(id);
    }
    
    public boolean existsByEduCarrera(String eduCarrera) {
        return repEducacion.existsByEduCarrera(eduCarrera);
    }
}
