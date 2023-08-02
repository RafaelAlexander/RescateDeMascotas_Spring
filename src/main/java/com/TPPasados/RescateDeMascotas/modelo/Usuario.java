package com.TPPasados.RescateDeMascotas.modelo;

import com.TPPasados.RescateDeMascotas.exceptions.ContraseniaInvalidaException;
import com.TPPasados.RescateDeMascotas.modelo.validacion.ReglaValidacion;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Usuario {
    @Getter
    @Setter
    @NonNull
    private String nombre;
    @Getter
    @NonNull
    private String contrasenia;
    @Getter
    @Setter
    @NonNull
    private RolUsuario rolUsuario;

    @Getter
    @Setter
    @NonNull
    private List<ReglaValidacion> reglas;

    public Usuario(String nombre, String contrasenia, RolUsuario rolUsuario, List<ReglaValidacion> reglas) throws IOException, URISyntaxException {
        this.nombre = nombre;
        this.reglas = reglas;
        setContrasenia(contrasenia);
        this.rolUsuario = rolUsuario;
    }

    public void setContrasenia(String contrasenia) {
        boolean cumpleTodo = reglas.stream().allMatch(r -> {
            try {
                return r.verificar(contrasenia);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
        if (!cumpleTodo) {
            throw new ContraseniaInvalidaException("La contraseña no cumple con las validacion requeridas");
        }
        this.contrasenia = contrasenia;
    }
}
