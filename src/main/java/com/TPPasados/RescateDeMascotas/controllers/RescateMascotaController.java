package com.TPPasados.RescateDeMascotas.controllers;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.repositorios.ServicioMascotasEncontradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "mascotasRescatadas")
public class RescateMascotaController {
    private final ServicioMascotasEncontradas repo;

    @Autowired
    public RescateMascotaController(ServicioMascotasEncontradas repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<MascotaEncontrada> obtenerMascotasEncontradas() {
        return repo.obtenerTodasMascotasEncontradas();
    }
}
