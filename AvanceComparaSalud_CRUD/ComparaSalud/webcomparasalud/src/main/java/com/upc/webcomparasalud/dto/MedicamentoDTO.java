package com.upc.webcomparasalud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDTO {
    private Long id;
    private String nommbreComercial;
    private String principioActivo;
    private String laboratorio;
    private String presentacion;
    private LocalDate fechaActualizacion;
}
