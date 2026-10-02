package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.dto.ServicioDTO;
import com.upc.webcomparasalud.entidades.Servicio;
import com.upc.webcomparasalud.repositorios.ServicioRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioServicio {
    @Autowired
    private ServicioRepositorio servicioRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ServicioDTO insertar(ServicioDTO servicioDTO) {
        Servicio servicio = modelMapper.map(servicioDTO, Servicio.class);
        Servicio servicioGrabado = servicioRepositorio.save(servicio);
        return modelMapper.map(servicioGrabado, ServicioDTO.class);
    }

    public List<ServicioDTO> listar() {
        return servicioRepositorio.findAll().stream().
                map(servicio -> modelMapper.
                        map(servicio, ServicioDTO.class)).
                collect(Collectors.toList());
    }
    public ServicioDTO obtenerPorId(Long id) {
        Servicio servicio = servicioRepositorio.findById(id).orElse(null);
        if (servicio == null) {
            return null;
        }
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    public void eliminar(Long id) {
        servicioRepositorio.deleteById(id);
    }
    public ServicioDTO modificar(ServicioDTO servicioDTO) {
        Servicio servicio = modelMapper.map(servicioDTO, Servicio.class);
        Servicio servicioActualizado = servicioRepositorio.save(servicio);
        return modelMapper.map(servicioActualizado, ServicioDTO.class);
    }
}
