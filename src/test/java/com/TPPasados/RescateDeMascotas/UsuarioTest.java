package com.TPPasados.RescateDeMascotas;

import com.TPPasados.RescateDeMascotas.exceptions.ContraseniaInvalidaException;
import com.TPPasados.RescateDeMascotas.modelo.RolUsuario;
import com.TPPasados.RescateDeMascotas.modelo.Usuario;
import com.TPPasados.RescateDeMascotas.modelo.validacion.CaracteresConsecutivos;
import com.TPPasados.RescateDeMascotas.modelo.validacion.DiezKProhibidas;
import com.TPPasados.RescateDeMascotas.modelo.validacion.ReglaValidacion;
import com.TPPasados.RescateDeMascotas.modelo.validacion.ValidacionGeneral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {

    private List<ReglaValidacion> reglas;

    @BeforeEach
    public void plantearReglas() {
        reglas = new ArrayList<>();
        reglas.add(new CaracteresConsecutivos());
        reglas.add(new DiezKProhibidas());
        reglas.add(new ValidacionGeneral());
    }

    @Test
    public void crearUsuarioConMenorAOchoTest() {
        Exception exception = Assertions.assertThrows(ContraseniaInvalidaException.class,
                () -> {
                    new Usuario("TEST", "68LxVZ%", RolUsuario.DUENIO, reglas);
                });
        String msg = exception.getMessage();
        Assertions.assertEquals(msg, "La contraseña no cumple con las validacion requeridas");
    }

    @Test
    public void crearUsuarioConCaracterRepetidoSeguido() {
        Exception exception = Assertions.assertThrows(ContraseniaInvalidaException.class,
                () -> {
                    new Usuario("TEST", "68LLxVZy3jHG4%", RolUsuario.DUENIO, reglas);
                });
        String msg = exception.getMessage();
        Assertions.assertEquals(msg, "La contraseña no cumple con las validacion requeridas");
    }

    @Test
    public void crearUsuarioConContraseniaSinCaracterEspecial() {
        Exception exception = Assertions.assertThrows(ContraseniaInvalidaException.class,
                () -> {
                    new Usuario("TEST", "68LxVZy3jHG4", RolUsuario.DUENIO, reglas);
                });
        String msg = exception.getMessage();
        Assertions.assertEquals(msg, "La contraseña no cumple con las validacion requeridas");
    }

    @Test
    public void crearUsuarioConContraseniaProhibida() {
        Exception exception = Assertions.assertThrows(ContraseniaInvalidaException.class,
                () -> {
                    new Usuario("TEST", "spanky", RolUsuario.DUENIO, reglas);
                });
        String msg = exception.getMessage();
        Assertions.assertEquals(msg, "La contraseña no cumple con las validacion requeridas");
    }

    @Test
    public void crearUsuarioConContraseniaExitosa() throws IOException, URISyntaxException {
        Usuario usuario = new Usuario("TEST", "68LxVZy3jHG4%", RolUsuario.DUENIO, reglas);
        Assertions.assertTrue(!usuario.equals(null));
    }
}
