package com.TPPasados.RescateDeMascotas.modelo.validacion;

import com.TPPasados.RescateDeMascotas.RescateDeMascotasApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DiezKProhibidas implements ReglaValidacion {
    @Override
    public boolean verificar(String palabra) throws IOException, URISyntaxException {
        return !obtenerPalabrasProhibidas().contains(palabra);
    }

    private List<String> obtenerPalabrasProhibidas() throws IOException, URISyntaxException {
        return Files.readAllLines(Paths.get(RescateDeMascotasApplication.class.getResource("/10-million-password-list-top-10000.txt").toURI()));
    }
}
