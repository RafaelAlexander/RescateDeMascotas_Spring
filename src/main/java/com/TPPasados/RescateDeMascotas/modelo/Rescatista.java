package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Rescatista {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    private String direccion;
    private List<Contacto> contatos;
    private MascotaEncontrada mascotaEncontrada;
}
