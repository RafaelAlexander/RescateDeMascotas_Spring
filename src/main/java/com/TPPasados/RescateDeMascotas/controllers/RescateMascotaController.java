package com.TPPasados.RescateDeMascotas.controllers;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.repositorios.ServicioMascotasEncontradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "mascotas-rescatadas")
public class RescateMascotaController {
    @Autowired
    private ServicioMascotasEncontradas repo;

    /*@GetMapping("/diez-dias")
    public List<MascotaEncontrada> obtenerEncontradas10Dias(){
        return repo.encontradas10Dias();
    }*/

    @GetMapping()
    public List<MascotaEncontrada> obtenerMascotasEncontradas() {
        return repo.obtenerTodasMascotasEncontradas();
    }


}
