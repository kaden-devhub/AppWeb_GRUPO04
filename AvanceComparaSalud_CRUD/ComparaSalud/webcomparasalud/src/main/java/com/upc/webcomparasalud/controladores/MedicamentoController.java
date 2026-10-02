package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.entidades.Medicamento;
import com.upc.webcomparasalud.servicios.MedicamentoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MedicamentoController {
    @Autowired
    private MedicamentoServicio medicamentoServicio;

    @PostMapping("/medicamento")
    public MedicamentoDTO insertar(@RequestBody MedicamentoDTO medicamentoDTO){
        return medicamentoServicio.insertar(medicamentoDTO);
    }

    @GetMapping("/medicamentos")
    public List<MedicamentoDTO> listar(){
        log.debug("Iniciando lista de medicamentos");
        return medicamentoServicio.listar();
    }
    @GetMapping("/medicamento/{id}")
    public MedicamentoDTO obtenerPorId(@PathVariable Long id) {
        return medicamentoServicio.obtenerPorId(id);
    }

    @DeleteMapping("/medicamento/{id}")
    public void eliminar(@PathVariable Long id) {
        medicamentoServicio.eliminar(id);
    }
    @PutMapping("/medicamento")
    public MedicamentoDTO modificar(@RequestBody MedicamentoDTO medicamentoDTO) {
        return medicamentoServicio.modificar(medicamentoDTO);
    }
}
