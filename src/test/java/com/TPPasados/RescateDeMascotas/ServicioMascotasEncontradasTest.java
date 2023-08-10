package com.TPPasados.RescateDeMascotas;

import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.servicios.ServicioMascotasEncontradas;
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
        repo.agregar(mascotaEncontrada, null);
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
        this.repo.agregar(mascotaEncontrada, null);
        int tamanio = repo.encontradas10Dias().size();
        System.out.println(tamanio);
        Boolean noHayMascota = tamanio == 0;
        Assert.isTrue(noHayMascota, "No hay mascota");
    }
}
