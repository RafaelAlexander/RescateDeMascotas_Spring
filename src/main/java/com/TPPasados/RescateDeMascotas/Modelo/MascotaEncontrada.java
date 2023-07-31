package com.TPPasados.RescateDeMascotas.Modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
