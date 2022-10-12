package com.wportfolio.hhpx.Repository;

import com.wportfolio.hhpx.Entity.Estudios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudios extends JpaRepository<Estudios, Integer> {
    public Optional<Estudios> findByEstCarrera(String estCarrera);
    public boolean existsByEstCarrera(String estCarrera);
}
