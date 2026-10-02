package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Especialidad;
import com.upc.webcomparasalud.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {

    
}
