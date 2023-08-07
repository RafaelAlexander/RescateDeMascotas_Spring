package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mascotaencontrada")
public class MascotaEncontrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chapita;
    private String fotos;
    private String descActual;
    private Double latitud;
    private Double longitud;
    private LocalDate fechaEncontrada;

    public MascotaEncontrada(String chapita,
                             String fotos,
                             String descActual,
                             Double latitud,
                             Double longitud,
                             LocalDate fechaEncontrada) {
        this.chapita = chapita;
        this.fotos = fotos;
        this.descActual = descActual;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaEncontrada = fechaEncontrada;
    }

    public boolean fuisteEncontradaDespues(LocalDate fecha) {
        return this.fechaEncontrada.isAfter(fecha);
    }
}
