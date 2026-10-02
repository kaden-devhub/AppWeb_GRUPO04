package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.UsuarioDTO;
import com.upc.webcomparasalud.entidades.Usuario;
import com.upc.webcomparasalud.servicios.UsuarioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/usuario")
    public UsuarioDTO insertar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.insertar(usuarioDTO);
    }

    @GetMapping("/usuarios")
    public List<UsuarioDTO> listar() {
        log.debug("Iniciando lista de usuarios");
        return usuarioServicio.listar();

    }
    @GetMapping("/usuario/{id}")
    public UsuarioDTO obtenerPorId(@PathVariable Long id) {
        return usuarioServicio.obtenerPorId(id);
    }

    @DeleteMapping("/usuario/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioServicio.eliminar(id);
    }
    @PutMapping("/usuario")
    public UsuarioDTO modificar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.modificar(usuarioDTO);
    }
}
