package com.TPPasados.RescateDeMascotas.Modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "MascotaEncontrada")
public class MascotaEncontrada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String Chapita;
    @NonNull
    @ElementCollection
    private List<String> fotos;
    @NonNull
    private String descActual;
    @NonNull
    private Double latitud;
    @NonNull
    private Double longitud;
    @NonNull
    private LocalDate fechaEncontrada;

    public boolean fuisteEncontradaDespues(LocalDate fecha){
        return this.fechaEncontrada.isAfter(fecha);
    }
}
