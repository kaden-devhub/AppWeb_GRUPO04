package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.UsuarioDTO;
import com.upc.webcomparasalud.entidades.Usuario;
import com.upc.webcomparasalud.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public UsuarioDTO insertar(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario usuarioGrabado = usuarioRepositorio.save(usuario);
        return modelMapper.map(usuarioGrabado, UsuarioDTO.class);
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepositorio.findAll().stream().
                map(usuario -> modelMapper.
                        map(usuario, UsuarioDTO.class)).
                collect(Collectors.toList());
    }
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }
    public UsuarioDTO modificar(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario usuarioActualizado = usuarioRepositorio.save(usuario);
        return modelMapper.map(usuarioActualizado, UsuarioDTO.class);
    }
}
