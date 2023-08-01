package com.TPPasados.RescateDeMascotas.modelo.validacion;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ReglaValidacion {
    boolean verificar(String palabra) throws IOException, URISyntaxException;
}
