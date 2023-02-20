package com.example.SpringTwitter.ajusteMensaje.controller;

import com.example.SpringTwitter.ajusteMensaje.application.AjusteMensajeService;
import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeInputDto;
import com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje.AjusteMensajeOutputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajuste")
public class AjusteMensajeController {
    @Autowired
    AjusteMensajeService ajusteMensajeService;

    @PostMapping
    public AjusteMensajeOutputDto añadirAjuste(@RequestBody AjusteMensajeInputDto ajusteMensajeInputDto) throws Exception {
        return ajusteMensajeService.añadirAjuste(ajusteMensajeInputDto);
    }

    @GetMapping("/id/{id}")
    public AjusteMensajeOutputDto obtenerAjustePorId(@PathVariable Integer id) throws EntityNotFoundException {
        return ajusteMensajeService.obtenerAjustePorId(id);
    }

    @GetMapping("/ajustes")
    public List<AjusteMensajeOutputDto> obtenerListaAjustes(){
        return ajusteMensajeService.obtenerAjustes();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarAjuste(@PathVariable Integer id) throws Exception {
        ajusteMensajeService.borrarAjuste(id);
    }
    @PutMapping("/actualizar/{id}")
    public AjusteMensajeOutputDto actualizarAjuste(@PathVariable Integer id, @RequestBody AjusteMensajeInputDto ajusteMensajeInputDto) throws Exception {
        return ajusteMensajeService.actualizarAjuste(id, ajusteMensajeInputDto);
    }
}
