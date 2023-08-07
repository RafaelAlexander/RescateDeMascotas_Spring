package com.TPPasados.RescateDeMascotas.controllers;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.repositorios.ServicioMascotasEncontradas;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "mascotas-rescatadas")
public class RescateMascotaController {

    private final ServicioMascotasEncontradas repo;

    @GetMapping()
    public List<MascotaEncontrada> obtenerMascotasEncontradas() {
        return repo.obtenerTodasMascotasEncontradas();
    }


}
