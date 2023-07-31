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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String chapita;
    @NonNull
    private String fotos;
    @NonNull
    private String descActual;
    @NonNull
    private Double latitud;
    @NonNull
    private Double longitud;
    @NonNull
    private LocalDate fechaEncontrada;

    public boolean fuisteEncontradaDespues(LocalDate fecha) {
        return this.fechaEncontrada.isAfter(fecha);
    }
}
