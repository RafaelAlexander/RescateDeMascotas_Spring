package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class Rescatista {
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private LocalDate fechaNacimiento;
    @Getter
    @Setter
    private TipoDocumento tipoDocumento;
    @Getter
    @Setter
    private String nroDocumento;
    @Getter
    @Setter
    private String direccion;
    @Getter
    @Setter
    private List<Contacto> contatos;
    @Getter
    @Setter
    private MascotaEncontrada mascotaEncontrada;


}
