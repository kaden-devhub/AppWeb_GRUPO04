package com.upc.webcomparasalud.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numerocolegiatura;
    private String nombre;
    private String apellido;
    private String experiencia;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;
    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroMedico centroMedico;
}

