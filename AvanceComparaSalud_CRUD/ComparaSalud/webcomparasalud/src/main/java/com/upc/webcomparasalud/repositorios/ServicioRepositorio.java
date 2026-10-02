package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

    // Listado de servicios con precios en una sede
    @Query("Select s from Servicio s where s.centroMedico.id = :idCentro order by s.precioServicio asc")
    public List<Servicio> listarPorCentro(Long idCentro);

}
