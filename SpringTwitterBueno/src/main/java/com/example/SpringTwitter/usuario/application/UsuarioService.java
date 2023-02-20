package com.example.SpringTwitter.usuario.application;

import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioInputDto;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioOutputDto;

import java.util.List;

public interface UsuarioService {
    UsuarioOutputDto añadirUsuario(UsuarioInputDto usuarioInputDto);
    UsuarioOutputDto obtenerUsuarioPorId(Integer id);
    List<UsuarioOutputDto> obtenerUsuarios ();
    UsuarioOutputDto actualizarUsuario(Integer id, UsuarioInputDto usuarioInputDto);
    void borrarUsuario (Integer id);
}
