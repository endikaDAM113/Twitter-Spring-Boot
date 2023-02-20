package com.example.SpringTwitter.ajusteMensaje.application;

import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeInputDto;
import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeOutputDto;

import java.util.List;

public interface AjusteMensajeService {
    AjusteMensajeOutputDto añadirAjuste(AjusteMensajeInputDto ajusteMensajeInputDto);
    AjusteMensajeOutputDto obtenerAjustePorId(Integer id);
    List<AjusteMensajeOutputDto> obtenerAjustes ();
    AjusteMensajeOutputDto actualizarAjuste(Integer id, AjusteMensajeInputDto ajusteMensajeInputDto);
    void borrarAjuste (Integer id);
}
