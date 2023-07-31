package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Contacto {
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private String email;
}
