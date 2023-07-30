package com.TPPasados.RescateDeMascotas.Servicios;

import com.TPPasados.RescateDeMascotas.Repositorios.RepositorioMascotasEncontradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMascotasEncontradas {
    @Autowired
    private RepositorioMascotasEncontradas repositorioMascotasEncontradas;


}
