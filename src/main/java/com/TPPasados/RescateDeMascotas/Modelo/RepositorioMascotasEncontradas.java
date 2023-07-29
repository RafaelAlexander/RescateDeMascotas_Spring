package com.TPPasados.RescateDeMascotas.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioMascotasEncontradas {
    private RepositorioMascotasEncontradas intancia = new RepositorioMascotasEncontradas();
    private List<MascotaPerdida> mascotaPerdidas = new ArrayList<>();

    private RepositorioMascotasEncontradas() {

    }

    public RepositorioMascotasEncontradas obtenerIntancia() {
        return this.intancia;
    }

    public void agregarMascotaPerdida(MascotaPerdida mascotaPerdida) {
        this.mascotaPerdidas.add(mascotaPerdida);
    }

    public List<MascotaPerdida> encontradas10Dias() {
        LocalDate fecha10DiasAtras = LocalDate.now().minusDays(10);
        return this.mascotaPerdidas
                .stream()
                .filter(mascotaPerdida -> mascotaPerdida.fuisteEncontradaDespues(fecha10DiasAtras))
                .collect(Collectors.toList());
    }
}
