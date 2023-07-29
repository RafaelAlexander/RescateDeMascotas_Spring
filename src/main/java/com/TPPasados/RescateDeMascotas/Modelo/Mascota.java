package com.TPPasados.RescateDeMascotas.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Mascota {
    @Getter
    private TipoMascota tipoMascota;
    @Getter
    private String nombre;
    @Getter
    @Setter
    private String apodo;
    @Getter
    @Setter
    private double edadAprox;
    @Getter
    private Sexo sexo;
    @Getter
    @Setter
    private String descFisica;
    @Getter
    @Setter
    private List<String> fotos;
    @Getter
    private List<CaracteristicaPersonalizada> caracteristicaPersonalizada;

    public void agregarCaracteristicaPersonalizada(CaracteristicaPersonalizada caracteristicaPersonalizada) {
        this.caracteristicaPersonalizada.add(caracteristicaPersonalizada);
    }
}
