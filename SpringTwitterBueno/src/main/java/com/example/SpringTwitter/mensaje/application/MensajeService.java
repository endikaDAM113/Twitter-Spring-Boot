package com.example.SpringTwitter.mensaje.application;

import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeInputDto;
import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeOutputDto;

import java.util.List;

public interface MensajeService {
    MensajeOutputDto añadirMensaje(MensajeInputDto mensajeInputDto);
    MensajeOutputDto obtenerMensajePorId(Integer id);
    List<MensajeOutputDto> obtenerMensajes ();
    MensajeOutputDto actualizarMensaje(Integer id, MensajeInputDto mensajeInputDto);
    void borrarMensaje (Integer id);
}
