package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.EspecialidadDTO;
import com.upc.webcomparasalud.entidades.Especialidad;
import com.upc.webcomparasalud.servicios.EspecialidadServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EspecialidadController {
    @Autowired
    private EspecialidadServicio especialidadServicio;

    @PostMapping("/especialidad")
    public EspecialidadDTO insertar(@RequestBody EspecialidadDTO especialidadDTO){
        return  especialidadServicio.insertar(especialidadDTO);
    }

    @GetMapping("especialidades")
    public List<EspecialidadDTO> listar(){
        log.debug("Iniciando lista de especialidades");
        return especialidadServicio.listar();
    }
    @GetMapping("/especialidad/{id}")
    public EspecialidadDTO obtenerPorId(@PathVariable Long id) {
        return especialidadServicio.obtenerPorId(id);
    }

    @DeleteMapping("/especialidad/{id}")
    public void eliminar(@PathVariable Long id) {
        especialidadServicio.eliminar(id);
    }
    @PutMapping("/especialidad")
    public EspecialidadDTO modificar(@RequestBody EspecialidadDTO especialidadDTO) {
        return especialidadServicio.modificar(especialidadDTO);
    }
}
