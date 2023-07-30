package com.TPPasados.RescateDeMascotas.Repositorios;

import com.TPPasados.RescateDeMascotas.Modelo.MascotaEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMascotasEncontradas {

    private final RepositorioMascotasEncontradas repo;

    @Autowired
    public ServicioMascotasEncontradas(RepositorioMascotasEncontradas repo) {
        this.repo = repo;
    }

    public void agregar(MascotaEncontrada mascotaEncontrada) {
        repo.save(mascotaEncontrada);
    }
}
