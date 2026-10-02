package com.upc.webcomparasalud.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nommbreComercial;
    private String principioActivo;
    private String laboratorio;
    private String presentacion;
    private LocalDate fechaActualizacion;
    private String Descripcion;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroMedico centro;

}
