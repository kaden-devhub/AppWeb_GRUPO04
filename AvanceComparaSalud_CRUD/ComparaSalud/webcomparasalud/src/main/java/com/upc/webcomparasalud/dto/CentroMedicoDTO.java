package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.Servicio;
import com.upc.webcomparasalud.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CentroMedicoDTO {
    private Long id;
    private String direccion;
    private double latitud;
    private double longitud;
    private String tipoGestion;
    private String telefono;
    private Usuario usuario;

}
