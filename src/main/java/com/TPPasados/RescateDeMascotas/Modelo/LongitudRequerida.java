package com.TPPasados.RescateDeMascotas.Modelo;

import com.TPPasados.RescateDeMascotas.Exception.PalabraNoCumpleLongitudException;

public class LongitudRequerida implements Verificacion {
    @Override
    public void verificar(String palabra) {
        Integer tamanioRequerido = 8;
        if (palabra.length() < tamanioRequerido) {
            throw new PalabraNoCumpleLongitudException("La contraseña no cumple con " + tamanioRequerido);
        }
    }
}
