package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Caracteristica {
    @Getter
    @Setter
    private String nombre;
    @Getter
    private List<String> opciones;
}
