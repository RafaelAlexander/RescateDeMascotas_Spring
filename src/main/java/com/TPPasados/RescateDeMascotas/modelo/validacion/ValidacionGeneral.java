package com.TPPasados.RescateDeMascotas.modelo.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionGeneral implements ReglaValidacion {

    @Override
    public boolean verificar(String palabra) {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher m = p.matcher(palabra);
        return m.find();
    }
}
