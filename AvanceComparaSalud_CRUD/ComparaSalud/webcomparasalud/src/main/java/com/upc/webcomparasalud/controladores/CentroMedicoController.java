package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.CentroMedicoDTO;
import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.servicios.CentroMedicoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CentroMedicoController {
    @Autowired
    private CentroMedicoServicio centroMedicoServicio;

    @PostMapping("/centro-medico")
    public CentroMedicoDTO insertar(@RequestBody CentroMedicoDTO centroMedicoDTO){
        return centroMedicoServicio.insertar(centroMedicoDTO);
    }

    @GetMapping("/centros-medicos")
    public List<CentroMedicoDTO> listar(){
        log.debug("Iniciando lista de centros-medicos");
        return centroMedicoServicio.listar();
    }
    @GetMapping("/centro-medico/{id}")
    public CentroMedicoDTO obtenerPorId(@PathVariable Long id) {
        return centroMedicoServicio.obtenerPorId(id);
    }

    @DeleteMapping("/centro-medico/{id}")
    public void eliminar(@PathVariable Long id) {
        centroMedicoServicio.eliminar(id);
    }
    @PutMapping("/centro-medico")
    public CentroMedicoDTO modificar(@RequestBody CentroMedicoDTO centroMedicoDTO) {
        return centroMedicoServicio.modificar(centroMedicoDTO);
    }
}
