package com.TPPasados.RescateDeMascotas.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CaracteristicaPersonalizada {
    @Getter
    private Caracteristica caracteristica;
    @Getter
    private String valor;
}
