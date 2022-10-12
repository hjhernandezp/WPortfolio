package com.wportfolio.hhpx.Repository;

import com.wportfolio.hhpx.Entity.Cursos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCursos extends JpaRepository<Cursos, Integer> {
    public Optional<Cursos> findByCurNombre(String curNombre);
    public boolean existsByCurNombre(String curNombre);
}
