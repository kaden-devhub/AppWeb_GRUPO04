package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.dto.ServicioDTO;
import com.upc.webcomparasalud.entidades.Servicio;
import com.upc.webcomparasalud.servicios.ServicioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ServicioController {
    @Autowired
    private ServicioServicio servicioServicio;

    @PostMapping("/servicio")
    public ServicioDTO insertar(@RequestBody ServicioDTO servicioDTO){
        return servicioServicio.insertar(servicioDTO);
    }

    @GetMapping("/servicios")
    public List<ServicioDTO> listar(){
        log.debug("Iniciando lista de servicios");
        return  servicioServicio.listar();
    }
    @GetMapping("/servicio/{id}")
    public ServicioDTO obtenerPorId(@PathVariable Long id) {
        return servicioServicio.obtenerPorId(id);
    }

    @DeleteMapping("/servicio/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioServicio.eliminar(id);
    }
    @PutMapping("/servicio")
    public ServicioDTO modificar(@RequestBody ServicioDTO servicioDTO) {
        return servicioServicio.modificar(servicioDTO);
    }

}
