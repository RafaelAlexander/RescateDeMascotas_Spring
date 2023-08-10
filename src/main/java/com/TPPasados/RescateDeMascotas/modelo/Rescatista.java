package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rescatista")
public class Rescatista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    @Enumerated
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    private String direccion;
    @OneToMany
    @JoinColumn(name = "rescatistaId")
    private List<Contacto> contatos;
    @OneToOne
    @JoinColumn(name = "restatistaId")
    private MascotaEncontrada mascotaEncontrada;

    public Rescatista(String nombre,
                      String apellido,
                      LocalDate fechaNacimiento,
                      TipoDocumento tipoDocumento,
                      String nroDocumento,
                      String direccion,
                      List<Contacto> contatos,
                      MascotaEncontrada mascotaEncontrada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.direccion = direccion;
        this.contatos = contatos;
        this.mascotaEncontrada = mascotaEncontrada;
    }

    @Override
    public String toString() {
        return this.contatos.stream().map(Contacto::toString).collect(Collectors.joining(""));
    }
}
