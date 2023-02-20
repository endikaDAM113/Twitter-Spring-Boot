package com.example.SpringTwitter.mensaje.application;

import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeInputDto;
import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeOutputDto;
import com.example.SpringTwitter.mensaje.domain.Mensaje;
import com.example.SpringTwitter.mensaje.repository.MensajeRepository;
import com.example.SpringTwitter.usuario.application.UsuarioService;
import com.example.SpringTwitter.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService{
    @Autowired
    MensajeRepository mensajeRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public MensajeOutputDto añadirMensaje(MensajeInputDto mensajeInputDto) {
        Mensaje mensaje = mensajeInputDtoToEntity(mensajeInputDto);
        mensaje.setIdMensaje(mensaje.getIdMensaje());
        mensajeRepository.save(mensaje);
        MensajeOutputDto mensajeOutputDto = new MensajeOutputDto(mensaje);
        return mensajeOutputDto;
    }

    @Override
    public MensajeOutputDto obtenerMensajePorId(Integer id) {
        Mensaje mensaje = mensajeRepository.findById(id).orElseThrow();
        return new MensajeOutputDto(mensaje);
    }

    @Override
    public List<MensajeOutputDto> obtenerMensajes() {
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream().map(MensajeOutputDto::new).toList();
    }

    @Override
    public MensajeOutputDto actualizarMensaje(Integer id, MensajeInputDto mensajeInputDto) {
        Mensaje mensaje = mensajeRepository.findById(id).orElseThrow();
        mensaje.setMensaje(mensajeInputDto.getMensaje());

        mensajeRepository.save(mensaje);

        MensajeOutputDto mensajeOutputDto = new MensajeOutputDto();
        return mensajeOutputDto;
    }

    @Override
    public void borrarMensaje(Integer id) {
        mensajeRepository.delete(mensajeRepository.findById(id).orElseThrow());
    }

    public Mensaje mensajeInputDtoToEntity(MensajeInputDto mensajeInputDto) {
        Mensaje mensaje = new Mensaje();
        mensaje.setUsuario_emisor(usuarioRepository.findById(mensajeInputDto.getIdUsuarioEmisor()).orElseThrow());
        mensaje.setUsuario_receptor(usuarioRepository.findById(mensajeInputDto.getIdUsuarioReceptor()).orElseThrow());
        mensaje.setMensaje(mensajeInputDto.getMensaje());
        return mensaje;
    }
}
