package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacto")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
