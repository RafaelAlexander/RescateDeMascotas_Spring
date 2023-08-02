package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;

import java.util.List;

@Data
public class Duenio {
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    private List<Contacto> contactos;
    private List<Mascota> mascotas;
}
