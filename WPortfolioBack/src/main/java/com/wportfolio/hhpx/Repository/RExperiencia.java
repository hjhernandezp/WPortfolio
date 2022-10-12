package com.wportfolio.hhpx.Repository;

import com.wportfolio.hhpx.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Integer> {
    public Optional<Experiencia> findByExpEmpresa(String expEmpresa);
    public boolean existsByExpEmpresa(String expEmpresa);
}
