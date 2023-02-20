package com.example.SpringTwitter.usuario.controller.dtoUsuario;

import com.example.SpringTwitter.tendencia.domain.Tendencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioInputDto {
    private String nombreUsuario;
    private Integer idAjusteMensaje;
    private List<Integer> tendenciasList = new ArrayList<>();
}
