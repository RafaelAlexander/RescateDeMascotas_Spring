package com.TPPasados.RescateDeMascotas.repositorios;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioMascotasEncontradas {

    private final RepositorioMascotasEncontradas repo;

    @Autowired
    public ServicioMascotasEncontradas(RepositorioMascotasEncontradas repo) {
        this.repo = repo;
    }

    public void agregar(MascotaEncontrada mascotaEncontrada) {
        this.repo.save(mascotaEncontrada);
    }

    public List<MascotaEncontrada> encontradas10Dias() {
        LocalDate hoy = LocalDate.now();
        LocalDate hace10Dias = hoy.minusDays(10);
        return this.repo.findByFechaEncontradaBetween(hace10Dias, hoy);
    }

    public List<MascotaEncontrada> obtenerTodasMascotasEncontradas() {
        return this.repo.findAll();
    }
}
