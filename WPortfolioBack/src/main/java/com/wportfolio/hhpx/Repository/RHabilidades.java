package com.wportfolio.hhpx.Repository;

import com.wportfolio.hhpx.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidades extends JpaRepository<Habilidades, Integer> {
    public Optional<Habilidades> findByHabNombre(String habNombre);
    public boolean existsByHabNombre(String habNombre);
}

