package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.MedicoDTO;
import com.upc.webcomparasalud.entidades.Medico;
import com.upc.webcomparasalud.repositorios.MedicoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServicio {
    @Autowired
    private MedicoRepositorio medicoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public MedicoDTO insertar(MedicoDTO medicoDTO) {
        Medico medico = modelMapper.map(medicoDTO, Medico.class);
        Medico medicoGrabado = medicoRepositorio.save(medico);
        return modelMapper.map(medicoGrabado, MedicoDTO.class);
    }

    public List<MedicoDTO> listar() {
        return medicoRepositorio.findAll().stream().
                map(medico -> modelMapper.
                        map(medico, MedicoDTO.class)).
                collect(Collectors.toList());
    }
    public MedicoDTO obtenerPorId(Long id) {
        Medico medico = medicoRepositorio.findById(id).orElse(null);
        if (medico == null) {
            return null;
        }
        return modelMapper.map(medico, MedicoDTO.class);
    }

    public void eliminar(Long id) {
        medicoRepositorio.deleteById(id);
    }
    public MedicoDTO modificar(MedicoDTO medicoDTO) {
        Medico medico = modelMapper.map(medicoDTO, Medico.class);
        Medico medicoActualizado = medicoRepositorio.save(medico);
        return modelMapper.map(medicoActualizado, MedicoDTO.class);
    }
}
