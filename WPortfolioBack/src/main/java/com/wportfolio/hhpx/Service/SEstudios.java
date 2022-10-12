package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Estudios;
import com.wportfolio.hhpx.Repository.REstudios;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudios {
    @Autowired
    REstudios repEstudios;
    
    public List<Estudios> list() {
        return repEstudios.findAll();
        
    }
    
    public Optional<Estudios> getOne(int id) {
        return repEstudios.findById(id);
    }
    
    public Optional<Estudios> getByEstCarrera(String estCarrera) {
        return repEstudios.findByEstCarrera(estCarrera);
    }
    
    public void save(Estudios entEstudios) {
        repEstudios.save(entEstudios);
    }
    
    public void delete(int id) {
        repEstudios.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return repEstudios.existsById(id);
    }
    
    public boolean existsByEstCarrera(String estCarrera) {
        return repEstudios.existsByEstCarrera(estCarrera);
    }
    
}
