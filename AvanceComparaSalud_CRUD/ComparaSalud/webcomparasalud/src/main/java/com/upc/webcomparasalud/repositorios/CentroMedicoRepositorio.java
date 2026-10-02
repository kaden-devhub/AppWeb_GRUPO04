package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroMedicoRepositorio extends JpaRepository<CentroMedico, Long> {
    @Query("Select cm.servicio from CentroMedico cm where cm.id = :idCentroMedico")
    List<Servicio> EncontrarServicios(Long idCentroMedico);
}
