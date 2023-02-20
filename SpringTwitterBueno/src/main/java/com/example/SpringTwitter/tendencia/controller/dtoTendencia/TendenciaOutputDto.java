package com.example.SpringTwitter.tendencia.controller.dtoTendencia;

import com.example.SpringTwitter.tendencia.domain.Tendencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TendenciaOutputDto {
    private Integer idTendencia;
    private String nombreTendencia;
    private List<Integer> usuarioList = new ArrayList<>();

    public TendenciaOutputDto(Tendencia tendencia){
        setIdTendencia(tendencia.getIdTendencia());
        setNombreTendencia(tendencia.getNombreTendencia());

        List<Integer> usuarioList = new ArrayList<>();
        if(tendencia.getUsuarioList() != null) {
            if(tendencia.getUsuarioList().size()!=0){
                for(int i = 0; i < tendencia.getUsuarioList().size(); i++){
                    usuarioList.add(tendencia.getUsuarioList().get(i).getIdUsuario());
                }
            }
        }
        setUsuarioList(usuarioList);
    }
}
