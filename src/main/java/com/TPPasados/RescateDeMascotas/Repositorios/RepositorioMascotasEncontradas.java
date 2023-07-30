package com.TPPasados.RescateDeMascotas.Repositorios;

import com.TPPasados.RescateDeMascotas.Modelo.MascotaEncontrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMascotasEncontradas extends JpaRepository<MascotaEncontrada, Long> {

    //private List<MascotaPerdida> mascotaPerdidas = new ArrayList<>();

    /*public void agregarMascotaPerdida(MascotaPerdida mascotaPerdida) {
        this.mascotaPerdidas.add(mascotaPerdida);
    }

    public List<MascotaPerdida> encontradas10Dias() {
        LocalDate fecha10DiasAtras = LocalDate.now().minusDays(10);
        return this.mascotaPerdidas
                .stream()
                .filter(mascotaPerdida -> mascotaPerdida.fuisteEncontradaDespues(fecha10DiasAtras))
                .collect(Collectors.toList());
    }*/
}
