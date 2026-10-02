package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.entidades.Medicamento;
import com.upc.webcomparasalud.repositorios.MedicamentoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoServicio {
    @Autowired
    private MedicamentoRepositorio medicamentoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public MedicamentoDTO insertar(MedicamentoDTO medicamentoDTO) {
        //CONVIRTIENDO OTRA VEZ DTO A ENTIDAD
        Medicamento medicamento = modelMapper.map(medicamentoDTO, Medicamento.class);
        Medicamento medicamentoGrabado = medicamentoRepositorio.save(medicamento);
        return modelMapper.map(medicamentoGrabado, MedicamentoDTO.class);
    }

    public List<MedicamentoDTO> listar() {
        return medicamentoRepositorio.findAll().stream().
                map(medicamento -> modelMapper.
                        map(medicamento, MedicamentoDTO.class)).
                collect(Collectors.toList());
    }
    public MedicamentoDTO obtenerPorId(Long id) {
        Medicamento medicamento = medicamentoRepositorio.findById(id).orElse(null);
        if (medicamento == null) {
            return null;
        }
        return modelMapper.map(medicamento, MedicamentoDTO.class);
    }

    public void eliminar(Long id) {
        medicamentoRepositorio.deleteById(id);
    }
    public MedicamentoDTO modificar(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = modelMapper.map(medicamentoDTO, Medicamento.class);
        Medicamento medicamentoActualizado = medicamentoRepositorio.save(medicamento);
        return modelMapper.map(medicamentoActualizado, MedicamentoDTO.class);
    }
}
