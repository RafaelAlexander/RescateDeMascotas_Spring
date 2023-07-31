package com.TPPasados.RescateDeMascotas.Repositorios;

import com.TPPasados.RescateDeMascotas.Modelo.MascotaEncontrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorioMascotasEncontradas extends JpaRepository<MascotaEncontrada, Long> {

    List<MascotaEncontrada> findByFechaEncontradaBetween(LocalDate desde, LocalDate hasta);
}
