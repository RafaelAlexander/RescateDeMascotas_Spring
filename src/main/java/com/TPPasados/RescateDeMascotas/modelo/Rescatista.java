package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
}
