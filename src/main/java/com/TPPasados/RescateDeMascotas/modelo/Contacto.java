package com.TPPasados.RescateDeMascotas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contactos")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Contacto(String nombre,
                    String apellido,
                    String telefono,
                    String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        String telefono = this.telefono.isBlank() ? "" : " Telefono: " + this.telefono;
        String email = this.email.isBlank() ? "" : " Email: " + this.email;
        return "||Nombre: " + this.nombre + " Apellido: " + this.apellido + telefono + email + "||";
    }
}
