package com.TPPasados.RescateDeMascotas.servicios;

import com.TPPasados.RescateDeMascotas.modelo.Duenio;
import com.TPPasados.RescateDeMascotas.modelo.MascotaEncontrada;
import com.TPPasados.RescateDeMascotas.modelo.MedioPreferido;
import com.TPPasados.RescateDeMascotas.modelo.Rescatista;
import com.TPPasados.RescateDeMascotas.repositorios.RepositorioDuenio;
import com.TPPasados.RescateDeMascotas.repositorios.RepositorioMascotasEncontradas;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioMascotasEncontradas {

    private final RepositorioMascotasEncontradas repo;
    private final ServicioEmail servicioEmail;
    private final RepositorioDuenio repoDuenio;

    public void agregar(MascotaEncontrada mascotaEncontrada, Rescatista rescatista) {
        this.repo.save(mascotaEncontrada);
        List<Duenio> duenios = this.repoDuenio
                .findByChapita(mascotaEncontrada.getChapita());

        if (duenios.size() > 0) {
            Duenio duenio = duenios.get(0);
            if (duenio.tieneComoPreferido(MedioPreferido.EMAIL)) {
                String email = duenio.getEmail();
                String msg = "Se encontro a su mascota perdida." +
                        "Los contactos del rescatista son " + rescatista.toString();
                this.servicioEmail.envioMensaje(msg, "Se encontro a su mascota perdida", email);
            }
        }
    }

    public List<MascotaEncontrada> encontradas10Dias() {
        LocalDate hoy = LocalDate.now();
        LocalDate hace10Dias = hoy.minusDays(10);
        return this.repo.findByFechaEncontradaBetween(hace10Dias, hoy);
    }

    public List<MascotaEncontrada> obtenerTodasMascotasEncontradas() {
        return this.repo.findAll();
    }
}
