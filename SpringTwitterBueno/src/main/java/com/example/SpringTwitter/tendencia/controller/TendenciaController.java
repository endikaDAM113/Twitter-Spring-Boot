package com.example.SpringTwitter.tendencia.controller;

import com.example.SpringTwitter.tendencia.application.TendenciaService;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaInputDto;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaOutputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/tendencia")
public class TendenciaController {
    @Autowired
    TendenciaService tendenciaService;

    @PostMapping
    public TendenciaOutputDto añadirTendencia(@RequestBody TendenciaInputDto tendenciaInputDto) throws Exception {
        return tendenciaService.añadirTendencia(tendenciaInputDto);
    }

    @GetMapping("/id/{id}")
    public TendenciaOutputDto obtenerTendenciaPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return tendenciaService.obtenerTendenciaPorId(id);
    }

    @GetMapping("/tendencias")
    public List<TendenciaOutputDto> obtenerListaTendencias(@RequestParam(defaultValue = "0", required = false) int pageNumber, @RequestParam(defaultValue = "4", required = false) int pageSize){
        return tendenciaService.obtenerTendencias(pageNumber, pageSize);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarTendencia(@PathVariable Integer id) throws Exception {
        tendenciaService.borrarTendencia(id);
    }
    @PutMapping("/actualizar/{id}")
    public TendenciaOutputDto actualizarTendencia(@PathVariable Integer id, @RequestBody TendenciaInputDto tendenciaInputDto) throws Exception {
        return tendenciaService.actualizarTendencia(id, tendenciaInputDto);
    }
}
