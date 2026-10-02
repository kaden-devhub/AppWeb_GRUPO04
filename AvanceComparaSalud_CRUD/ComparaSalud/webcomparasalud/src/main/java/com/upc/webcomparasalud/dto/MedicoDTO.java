package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.Especialidad;
import com.upc.webcomparasalud.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long id;
    private Integer numerocolegiatura;
    private String nombre;
    private String apellido;
    private String experiencia;
    private Usuario usuario;
    private Especialidad especialidad;
}
