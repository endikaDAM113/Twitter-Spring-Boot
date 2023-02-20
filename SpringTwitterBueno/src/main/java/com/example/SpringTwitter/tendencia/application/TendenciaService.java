package com.example.SpringTwitter.tendencia.application;

import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaInputDto;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaOutputDto;
import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface TendenciaService {
    TendenciaOutputDto añadirTendencia(TendenciaInputDto tendenciaInputDto);
    TendenciaOutputDto obtenerTendenciaPorId(Integer id);
    List<TendenciaOutputDto> obtenerTendencias (int numPag, int tamPag);
    TendenciaOutputDto actualizarTendencia(Integer id, TendenciaInputDto tendenciaInputDto);
    void borrarTendencia (Integer id);

}
