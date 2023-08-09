package com.TPPasados.RescateDeMascotas.servicios;

import com.TPPasados.RescateDeMascotas.repositorios.RepositorioMascotas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioMascotas {
    private final RepositorioMascotas repo;


}
