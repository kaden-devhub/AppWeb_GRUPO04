package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long> {


}
