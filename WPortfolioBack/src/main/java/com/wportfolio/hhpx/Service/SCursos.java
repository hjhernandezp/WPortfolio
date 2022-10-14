package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Cursos;
import com.wportfolio.hhpx.Repository.RCursos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCursos {
    @Autowired
    RCursos repCursos;
    
    public List<Cursos> list() {
        return repCursos.findAll();
    }
    
    public Optional<Cursos> getOne(int id) {
        return repCursos.findById(id);
    }

    public Optional<Cursos> getByCurNombre(String curNombre) {
        return repCursos.findByCurNombre(curNombre);
    }

    public void save(Cursos entCursos) {
        repCursos.save(entCursos);
    }
    
    public void delete(int id) {
        repCursos.deleteById(id);
    }

    public boolean existsById(int id) {
        return repCursos.existsById(id);
    }

    public boolean existsByCurNombre(String curNombre) {
        return repCursos.existsByCurNombre(curNombre);
    }
}
