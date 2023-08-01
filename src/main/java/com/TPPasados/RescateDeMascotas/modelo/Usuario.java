package com.TPPasados.RescateDeMascotas.modelo;

import com.TPPasados.RescateDeMascotas.RescateDeMascotasApplication;
import com.TPPasados.RescateDeMascotas.exceptions.ContraseniaInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Usuario(String nombre, String contrasenia, RolUsuario rolUsuario) throws IOException, URISyntaxException {
        this.nombre = nombre;
        setContrasenia(contrasenia);
        this.rolUsuario = rolUsuario;
    }

    public void setContrasenia(String contrasenia) throws IOException, URISyntaxException {
        if (hayCaracteresConsecutivos(contrasenia) || !cumpleReglas(contrasenia) || estaEnPalabrasProhibidas(contrasenia)) {
            throw new ContraseniaInvalidaException("La contraseña no cumple con las validacion requeridas");
        }
        this.contrasenia = contrasenia;
    }

    private Boolean cumpleReglas(String contrasenia) {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher m = p.matcher(contrasenia);
        return m.find();
    }

    private Boolean hayCaracteresConsecutivos(String contrasenia) {
        Pattern p = Pattern.compile("(\\w)\\1+");
        Matcher m = p.matcher(contrasenia);
        return m.find();
    }

    private Boolean estaEnPalabrasProhibidas(String palabra) throws IOException, URISyntaxException {
        return obtenerPalabrasProhibidas().contains(palabra);
    }

    private static List<String> obtenerPalabrasProhibidas() throws IOException, URISyntaxException {
        return Files.readAllLines(Paths.get(RescateDeMascotasApplication.class.getResource("/10-million-password-list-top-10000.txt").toURI()));
    }
}
