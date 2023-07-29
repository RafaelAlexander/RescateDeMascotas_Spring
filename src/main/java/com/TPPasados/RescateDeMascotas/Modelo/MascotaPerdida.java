package com.TPPasados.RescateDeMascotas.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class MascotaPerdida {
    @Getter
    @Setter
    private String Chapita;
    @Getter
    private List<String> fotos;
    @Getter
    @Setter
    private String descActual;
    @Getter
    private double latitud;
    @Getter
    private double longitud;
    @Getter
    private LocalDate fechaEncontrada;

    public boolean fuisteEncontradaDespues(LocalDate fecha){
        return this.fechaEncontrada.isAfter(fecha);
    }
}
