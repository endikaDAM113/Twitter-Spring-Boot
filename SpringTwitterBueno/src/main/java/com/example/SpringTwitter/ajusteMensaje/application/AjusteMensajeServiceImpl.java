package com.example.SpringTwitter.ajusteMensaje.application;

import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeInputDto;
import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeOutputDto;
import com.example.SpringTwitter.ajusteMensaje.domain.AjusteMensaje;
import com.example.SpringTwitter.ajusteMensaje.repository.AjusteMensajeRepository;
import com.example.SpringTwitter.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjusteMensajeServiceImpl implements AjusteMensajeService{
    @Autowired
    AjusteMensajeRepository ajusteMensajeRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public AjusteMensajeOutputDto añadirAjuste(AjusteMensajeInputDto ajusteMensajeInputDto) {
        AjusteMensaje ajusteMensaje = ajusteInputDtoToEntity(ajusteMensajeInputDto);
        ajusteMensaje.setIdAjuste(ajusteMensaje.getIdAjuste());
        ajusteMensajeRepository.save(ajusteMensaje);
        AjusteMensajeOutputDto ajusteMensajeOutputDto = new AjusteMensajeOutputDto(ajusteMensaje);
        return ajusteMensajeOutputDto;
    }

    @Override
    public AjusteMensajeOutputDto obtenerAjustePorId(Integer id) {
        AjusteMensaje ajusteMensaje = ajusteMensajeRepository.findById(id).orElseThrow();
        return new AjusteMensajeOutputDto(ajusteMensaje);
    }

    @Override
    public List<AjusteMensajeOutputDto> obtenerAjustes() {
        List<AjusteMensaje> ajusteMensajes = ajusteMensajeRepository.findAll();
        return ajusteMensajes.stream().map(AjusteMensajeOutputDto::new).toList();
    }

    @Override
    public AjusteMensajeOutputDto actualizarAjuste(Integer id, AjusteMensajeInputDto ajusteMensajeInputDto) {
        AjusteMensaje ajusteMensaje = ajusteMensajeRepository.findById(id).orElseThrow();
        ajusteMensaje.setAjusteMensaje(ajusteMensajeInputDto.isAjusteMensaje());
        ajusteMensaje.setFiltroMensaje(ajusteMensajeInputDto.isFiltroMensaje());
        ajusteMensaje.setConfirmacionLectura(ajusteMensajeInputDto.isConfirmacionLectura());

        ajusteMensajeRepository.save(ajusteMensaje);

        AjusteMensajeOutputDto ajusteMensajeOutputDto = new AjusteMensajeOutputDto();
        return ajusteMensajeOutputDto;
    }

    @Override
    public void borrarAjuste(Integer id) {
        ajusteMensajeRepository.delete(ajusteMensajeRepository.findById(id).orElseThrow());
    }

    public AjusteMensaje ajusteInputDtoToEntity(AjusteMensajeInputDto ajusteMensajeInputDto) {
        AjusteMensaje ajusteMensaje = new AjusteMensaje();
        ajusteMensaje.setUsuario(usuarioRepository.findById(ajusteMensajeInputDto.getIdUsuario()).orElseThrow());
        ajusteMensaje.setAjusteMensaje(ajusteMensajeInputDto.isAjusteMensaje());
        ajusteMensaje.setFiltroMensaje(ajusteMensajeInputDto.isFiltroMensaje());
        ajusteMensaje.setConfirmacionLectura(ajusteMensajeInputDto.isConfirmacionLectura());
        return ajusteMensaje;
    }
}
