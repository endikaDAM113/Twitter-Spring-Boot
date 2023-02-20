package com.example.SpringTwitter.tendencia.application;

import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaInputDto;
import com.example.SpringTwitter.tendencia.controller.dtoTendencia.TendenciaOutputDto;
import com.example.SpringTwitter.tendencia.domain.Tendencia;
import com.example.SpringTwitter.tendencia.repository.TendenciaRepository;
import com.example.SpringTwitter.usuario.domain.Usuario;
import com.example.SpringTwitter.usuario.repository.UsuarioRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TendenciaServiceImpl implements TendenciaService{
    @Autowired
    TendenciaRepository tendenciaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    private final Path rootFolder = Paths.get("uploads");

    @Override
    public TendenciaOutputDto añadirTendencia(TendenciaInputDto tendenciaInputDto) {
        Tendencia tendencia = tendenciaInputDtoToEntity(tendenciaInputDto);
        tendenciaRepository.save(tendencia);
        TendenciaOutputDto tendenciaOutputDto = new TendenciaOutputDto(tendencia);
        return tendenciaOutputDto;
    }

    @Override
    public TendenciaOutputDto obtenerTendenciaPorId(Integer id) {
        Tendencia tendencia = tendenciaRepository.findById(id).orElseThrow();
        return new TendenciaOutputDto(tendencia);
    }

    @Override
    public List<TendenciaOutputDto> obtenerTendencias(int numPag, int tamPag) {
        PageRequest pageRequest = PageRequest.of(numPag, tamPag);
        return tendenciaRepository.findAll(pageRequest).getContent().stream().map(TendenciaOutputDto::new).toList();
    }

    @Override
    public TendenciaOutputDto actualizarTendencia(Integer id, TendenciaInputDto tendenciaInputDto) {
        Tendencia tendencia = tendenciaRepository.findById(id).orElseThrow();
        tendencia.setNombreTendencia(tendencia.getNombreTendencia());

        if (tendenciaInputDto.getUsuarioList()!=null)
        {
            List<Usuario> usuarios=new ArrayList<>();
            for (int usuario: tendenciaInputDto.getUsuarioList())
            {
                Usuario usuario1= usuarioRepository.findById(usuario).orElseThrow();
                usuarios.add(usuario1);
            }
            tendencia.setUsuarioList(usuarios);
        }
        tendenciaRepository.save(tendencia);
        TendenciaOutputDto tendenciaOutputDto = new TendenciaOutputDto();
        return tendenciaOutputDto;
    }

    @Override
    public void borrarTendencia(Integer id) {
        tendenciaRepository.delete(tendenciaRepository.findById(id).orElseThrow());
    }

    public Tendencia tendenciaInputDtoToEntity(TendenciaInputDto tendenciaInputDto) {
        Tendencia tendencia = new Tendencia();
        tendencia.setNombreTendencia(tendenciaInputDto.getNombreTendencia());
        if (tendenciaInputDto.getUsuarioList()!=null)
        {
            List<Usuario> usuarios=new ArrayList<>();
            for (int usuario: tendenciaInputDto.getUsuarioList())
            {
                Usuario usuario1= usuarioRepository.findById(usuario).orElseThrow();
                usuarios.add(usuario1);
            }
            tendencia.setUsuarioList(usuarios);
        }
        return tendencia;
    }
}
