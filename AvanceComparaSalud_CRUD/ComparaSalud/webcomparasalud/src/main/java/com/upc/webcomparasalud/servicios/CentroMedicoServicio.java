package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.CentroMedicoDTO;
import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.repositorios.CentroMedicoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroMedicoServicio {
    @Autowired
    private CentroMedicoRepositorio centroMedicoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public CentroMedicoDTO insertar(CentroMedicoDTO centroMedicoDTO){
        CentroMedico centroMedico = modelMapper.map(centroMedicoDTO, CentroMedico.class);
        CentroMedico centroMedicoGrabado = centroMedicoRepositorio.save(centroMedico);
        return modelMapper.map(centroMedicoGrabado, CentroMedicoDTO.class);
    }

    public List<CentroMedicoDTO> listar(){
        return centroMedicoRepositorio.findAll().stream().
                map(centroMedico -> modelMapper.
                        map(centroMedico, CentroMedicoDTO.class)).
                collect(Collectors.toList());
    }
    public CentroMedicoDTO obtenerPorId(Long id) {
        CentroMedico centroMedico = centroMedicoRepositorio.findById(id).orElse(null);
        if (centroMedico == null) {
            return null;
        }
        return modelMapper.map(centroMedico, CentroMedicoDTO.class);
    }

    public void eliminar(Long id) {
        centroMedicoRepositorio.deleteById(id);
    }
    public CentroMedicoDTO modificar(CentroMedicoDTO centroMedicoDTO) {
        CentroMedico centroMedico = modelMapper.map(centroMedicoDTO, CentroMedico.class);
        CentroMedico centroActualizado = centroMedicoRepositorio.save(centroMedico);
        return modelMapper.map(centroActualizado, CentroMedicoDTO.class);
    }
}
