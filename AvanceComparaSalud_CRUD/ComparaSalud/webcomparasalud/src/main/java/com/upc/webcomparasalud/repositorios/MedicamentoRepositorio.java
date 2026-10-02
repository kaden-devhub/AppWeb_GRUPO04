package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long> {

}
