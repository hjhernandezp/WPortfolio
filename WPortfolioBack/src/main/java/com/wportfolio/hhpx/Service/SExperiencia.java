package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Experiencia;
import com.wportfolio.hhpx.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia repExperiencia;
    
    public List<Experiencia> list() {
        return repExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return repExperiencia.findById(id);
    }

    public Optional<Experiencia> getByExpEmpresa(String expEmpresa) {
        return repExperiencia.findByExpEmpresa(expEmpresa);
    }

    public void save(Experiencia entExperiencia) {
        repExperiencia.save(entExperiencia);
    }
    
    public void delete(int id) {
        repExperiencia.deleteById(id);
    }

    public boolean existsById(int id) {
        return repExperiencia.existsById(id);
    }

    public boolean existsByExpEmpresa(String expEmpresa) {
        return repExperiencia.existsByExpEmpresa(expEmpresa);
    }

}
