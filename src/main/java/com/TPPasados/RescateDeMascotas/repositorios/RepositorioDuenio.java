package com.TPPasados.RescateDeMascotas.repositorios;

import com.TPPasados.RescateDeMascotas.modelo.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDuenio extends JpaRepository<Duenio, Long> {
    @Query(value = "SELECT d FROM Duenio d JOIN d.mascotas m WHERE m.chapita = ?1")
    List<Duenio> findByChapita(String chapita);
}
