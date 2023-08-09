package com.TPPasados.RescateDeMascotas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "caracteristicas_personalizadas")
public class CaracteristicaPersonalizada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "caracteristica_id")
    private Caracteristica caracteristica;
    private String valor;

    public CaracteristicaPersonalizada(Caracteristica caracteristica,
                                       String valor) {
        this.caracteristica = caracteristica;
        this.valor = valor;
    }
}
