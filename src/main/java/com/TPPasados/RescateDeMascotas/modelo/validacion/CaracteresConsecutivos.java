package com.TPPasados.RescateDeMascotas.modelo.validacion;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaracteresConsecutivos implements ReglaValidacion {

    @Override
    public boolean verificar(String palabra) throws IOException, URISyntaxException {
        Pattern p = Pattern.compile("(\\w)\\1+");
        Matcher m = p.matcher(palabra);
        return !m.find();
    }
}
