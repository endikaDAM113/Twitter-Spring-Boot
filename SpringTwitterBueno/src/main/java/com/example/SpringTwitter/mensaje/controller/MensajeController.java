package com.example.SpringTwitter.mensaje.controller;

import com.example.SpringTwitter.mensaje.application.MensajeService;
import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeInputDto;
import com.example.SpringTwitter.mensaje.controller.dtoMensaje.MensajeOutputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    @Autowired
    MensajeService mensajeService;

    @PostMapping
    public MensajeOutputDto añadirAjuste(@RequestBody MensajeInputDto mensajeInputDto) throws Exception {
        return mensajeService.añadirMensaje(mensajeInputDto);
    }

    @GetMapping("/id/{id}")
    public MensajeOutputDto obtenerAjustePorId(@PathVariable Integer id) throws EntityNotFoundException {
        return mensajeService.obtenerMensajePorId(id);
    }

    @GetMapping("/mensajes")
    public List<MensajeOutputDto> obtenerListaAjustes(){
        return mensajeService.obtenerMensajes();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarAjuste(@PathVariable Integer id) throws Exception {
        mensajeService.borrarMensaje(id);
    }
    @PutMapping("/actualizar/{id}")
    public MensajeOutputDto actualizarAjuste(@PathVariable Integer id, @RequestBody MensajeInputDto mensajeInputDto) throws Exception {
        return mensajeService.actualizarMensaje(id, mensajeInputDto);
    }
}
