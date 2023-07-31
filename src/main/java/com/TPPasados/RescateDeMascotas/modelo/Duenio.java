package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Duenio {
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private TipoDocumento tipoDocumento;
    @Getter
    @Setter
    private String nroDocumento;
    @Getter
    @Setter
    private List<Contacto> contactos;


}
