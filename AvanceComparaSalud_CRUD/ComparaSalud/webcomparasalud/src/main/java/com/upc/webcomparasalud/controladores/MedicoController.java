package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.MedicoDTO;
import com.upc.webcomparasalud.entidades.Medico;
import com.upc.webcomparasalud.servicios.MedicoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MedicoController {
    @Autowired
    private MedicoServicio medicoServicio;

    @PostMapping("/medico")
    public MedicoDTO insertar(@RequestBody MedicoDTO medicoDTO){
        return medicoServicio.insertar(medicoDTO);
    }

    @GetMapping("/medicos")
    public List<MedicoDTO> listar(){
        log.debug("Iniciando lista de medicos");
        return medicoServicio.listar();
    }
    @GetMapping("/medico/{id}")
    public MedicoDTO obtenerPorId(@PathVariable Long id) {
        return medicoServicio.obtenerPorId(id);
    }

    @DeleteMapping("/medico/{id}")
    public void eliminar(@PathVariable Long id) {
        medicoServicio.eliminar(id);
    }
    @PutMapping("/medico")
    public MedicoDTO modificar(@RequestBody MedicoDTO medicoDTO) {
        return medicoServicio.modificar(medicoDTO);
    }
}
