package com.TPPasados.RescateDeMascotas.Modelo;

import com.TPPasados.RescateDeMascotas.Exception.OpcionCaracteristicaNoValidaException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Caracteristicas {
    @Getter
    @Setter
    private String nombre;
    @Getter
    private List<String> opciones;

    public void crearCaracteriticaPersonlizada(String opcion, Mascota mascota) {
        if (opcion.isEmpty()) {
            return;
        }
        if (this.opciones.contains(opcion)) {
            mascota.agregarCaracteristicaPersonalizada(new CaracteristicaPersonalizada(
                                    this.nombre,
                                    opcion));
        }
        throw new OpcionCaracteristicaNoValidaException("La opción "
                + opcion +
                "no es valida para la caracteristica "
                + this.nombre);
    }
}
