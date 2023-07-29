package com.TPPasados.RescateDeMascotas.Modelo;

import com.TPPasados.RescateDeMascotas.Exception.EsPalabraProhibidaException;
import com.TPPasados.RescateDeMascotas.RescateDeMascotasApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PalabraProhibida implements Verificacion {
    private final static List<String> palabrasProhibidas;

    static {
        try {
            palabrasProhibidas = obtenerPalabrasProhibidas();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void verificar(String palabra) {
        if (palabrasProhibidas.contains(palabra)) {
            throw new EsPalabraProhibidaException("Su contraseña esta en los 10K palabras mas vulnerables.");
        }
    }

    private static List<String> obtenerPalabrasProhibidas() throws IOException, URISyntaxException {
        return Files.readAllLines(Paths.get(RescateDeMascotasApplication.class.getResource("/10-million-password-list-top-10000.txt").toURI()));
    }
}
