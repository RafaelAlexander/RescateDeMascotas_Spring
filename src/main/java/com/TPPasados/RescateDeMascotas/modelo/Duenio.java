package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "duenios")
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Enumerated
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    @OneToMany
    @JoinColumn(name = "duenio_id")
    private List<Contacto> contactos;
    @OneToMany
    @JoinColumn(name = "duenio_id")
    private List<Mascota> mascotas;
    @ElementCollection
    private List<MedioPreferido> medioPreferidos;

    public Duenio(String nombre,
                  String apellido,
                  TipoDocumento tipoDocumento,
                  String nroDocumento,
                  List<Contacto> contactos,
                  List<Mascota> mascotas,
                  List<MedioPreferido> medioPreferidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.contactos = contactos;
        this.mascotas = mascotas;
        this.medioPreferidos = medioPreferidos;
    }

    public boolean tieneComoPreferido(MedioPreferido medioPreferido) {
        return this.medioPreferidos.contains(medioPreferido);
    }

    public String getEmail() {
        return this.contactos
                .stream()
                .map(Contacto::getEmail)
                .findFirst()
                .orElse(null);
    }
}
