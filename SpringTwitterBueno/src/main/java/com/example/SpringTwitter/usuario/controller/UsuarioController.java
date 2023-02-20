package com.example.SpringTwitter.usuario.controller;

import com.example.SpringTwitter.tendencia.application.TendenciaService;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaInputDto;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaOutputDto;
import com.example.SpringTwitter.usuario.application.UsuarioService;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioInputDto;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioOutputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public UsuarioOutputDto añadirUsuario(@RequestBody UsuarioInputDto usuarioInputDto) throws Exception {
        return usuarioService.añadirUsuario(usuarioInputDto);
    }

    @GetMapping("/id/{id}")
    public UsuarioOutputDto obtenerUsuarioPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/usuarios")
    public List<UsuarioOutputDto> obtenerListaUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarUsuario(@PathVariable Integer id) throws Exception {
        usuarioService.borrarUsuario(id);
    }
    @PutMapping("/actualizar/{id}")
    public UsuarioOutputDto actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioInputDto usuarioInputDto) throws Exception {
        return usuarioService.actualizarUsuario(id, usuarioInputDto);
    }
}
