package com.TPPasados.RescateDeMascotas.repositorios;

import com.TPPasados.RescateDeMascotas.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMascotas extends JpaRepository<Mascota, Long> {
    //TODO: Falta armar interface para sacar y test
}
