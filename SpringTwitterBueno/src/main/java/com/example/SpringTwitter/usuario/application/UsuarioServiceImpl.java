package com.example.SpringTwitter.usuario.application;

import com.example.SpringTwitter.tendencia.domain.Tendencia;
import com.example.SpringTwitter.tendencia.repository.TendenciaRepository;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioInputDto;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioOutputDto;
import com.example.SpringTwitter.usuario.domain.Usuario;
import com.example.SpringTwitter.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TendenciaRepository tendenciaRepository;

    @Override
    public UsuarioOutputDto añadirUsuario(UsuarioInputDto usuarioInputDto) {
        Usuario usuario = usuarioInputDtoToEntity(usuarioInputDto);
        usuarioRepository.save(usuario);
        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto(usuario);
        return usuarioOutputDto;
    }

    @Override
    public UsuarioOutputDto obtenerUsuarioPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioOutputDto(usuario);
    }

    @Override
    public List<UsuarioOutputDto> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioOutputDto::new).toList();
    }

    @Override
    public UsuarioOutputDto actualizarUsuario(Integer id, UsuarioInputDto usuarioInputDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNombreUsuario(usuarioInputDto.getNombreUsuario());
        usuarioRepository.save(usuario);
        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
        return usuarioOutputDto;
    }

    @Override
    public void borrarUsuario(Integer id) {
        tendenciaRepository.delete(tendenciaRepository.findById(id).orElseThrow());
    }

    private Usuario usuarioInputDtoToEntity(UsuarioInputDto usuarioInputDto){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioInputDto.getNombreUsuario());
        List<Tendencia> tendencias = new ArrayList<>();
        for (int i = 0; i < usuarioInputDto.getTendenciasList().size(); i++) {
            tendencias.add(tendenciaRepository.findById(usuarioInputDto.getTendenciasList().get(i)).orElseThrow());
        }
        usuario.setTendenciasList(tendencias);
        return usuario;

    }
}
