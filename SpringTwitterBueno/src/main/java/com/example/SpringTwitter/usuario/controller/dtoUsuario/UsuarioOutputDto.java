package com.example.SpringTwitter.usuario.controller.dtoUsuario;

import com.example.SpringTwitter.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDto {
    private Integer idUsuario;
    private String nombreUsuario;
    private List<Integer> tendenciasList = new ArrayList<>();


    public UsuarioOutputDto(Usuario usuario) {
        setIdUsuario(usuario.getIdUsuario());
        setNombreUsuario(usuario.getNombreUsuario());

        List<Integer> tendenciasList = new ArrayList<>();
        if(usuario.getTendenciasList().size()!=0){
            for(int i = 0; i < usuario.getTendenciasList().size(); i++){
                tendenciasList.add(usuario.getTendenciasList().get(i).getIdTendencia());
            }
        }
        setTendenciasList(tendenciasList);
    }
}
