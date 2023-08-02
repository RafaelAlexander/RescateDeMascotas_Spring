package com.TPPasados.RescateDeMascotas;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.repositorios.ServicioMascotasEncontradas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;


@SpringBootTest
public class ServicioMascotasEncontradasTest {
    @Autowired
    private ServicioMascotasEncontradas repo;

    @Test
    public void hayMascotaEncontradaDentro10Diaz() {
        MascotaEncontrada mascotaEncontrada = new MascotaEncontrada("TEST",
                "TEST",
                "TEST",
                1.0,
                1.0,
                LocalDate.now());
        repo.agregar(mascotaEncontrada);
        Boolean hayMascota = repo.encontradas10Dias().size() == 1;
        Assert.isTrue(hayMascota, "No hay mascota");
    }

    @Test
    public void noHayMascotaEncontradaDentro10Diaz() {
        MascotaEncontrada mascotaEncontrada = new MascotaEncontrada("TEST",
                "TEST",
                "TEST",
                1.0,
                1.0,
                LocalDate.now().minusDays(20));
        repo.agregar(mascotaEncontrada);
        Boolean noHayMascota = repo.encontradas10Dias().size() == 0;
        Assert.isTrue(noHayMascota, "No hay mascota");
    }
}
