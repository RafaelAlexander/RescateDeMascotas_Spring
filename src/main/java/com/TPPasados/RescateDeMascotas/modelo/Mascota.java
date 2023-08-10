package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    private String chapita;
    @Enumerated
    private TipoMascota tipoMascota;
    private String nombre;
    private String apodo;
    private double edadAprox;
    private Sexo sexo;
    private String descFisica;
    private String fotos;
    @OneToMany
    @JoinColumn(name = "mascota_id")
    private List<CaracteristicaPersonalizada> caracteristicaPersonalizada;

    public Mascota(TipoMascota tipoMascota,
                   String nombre,
                   String apodo,
                   double edadAprox,
                   Sexo sexo,
                   String descFisica,
                   String fotos,
                   List<CaracteristicaPersonalizada> caracteristicaPersonalizada) {
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edadAprox = edadAprox;
        this.sexo = sexo;
        this.descFisica = descFisica;
        this.fotos = fotos;
        this.caracteristicaPersonalizada = caracteristicaPersonalizada;
    }

    public void agregarCaracteristicaPersonalizada(CaracteristicaPersonalizada caracteristicaPersonalizada) {
        this.caracteristicaPersonalizada.add(caracteristicaPersonalizada);
    }
}
