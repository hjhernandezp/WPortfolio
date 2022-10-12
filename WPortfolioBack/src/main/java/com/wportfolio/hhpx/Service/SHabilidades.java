package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Habilidades;
import com.wportfolio.hhpx.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    @Autowired
    RHabilidades repHabilidades;
    
    public List<Habilidades> list() {
        return repHabilidades.findAll();
    }
    
    public Optional<Habilidades> getOne(int id) {
        return repHabilidades.findById(id);
    }
    
    public Optional<Habilidades> getByHabNombre(String habNombre) {
        return repHabilidades.findByHabNombre(habNombre);
    }
    
    public void save(Habilidades entHabilidades) {
        repHabilidades.save(entHabilidades);
    }
    
    public void delete(int id) {
        repHabilidades.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return repHabilidades.existsById(id);
    }
    
    public boolean existsByHabNombre(String habNombre) {
        return repHabilidades.existsByHabNombre(habNombre);
    }

}
