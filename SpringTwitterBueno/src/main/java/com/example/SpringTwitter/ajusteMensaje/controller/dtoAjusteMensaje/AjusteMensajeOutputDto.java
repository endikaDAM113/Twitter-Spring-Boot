package com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje;
import com.example.SpringTwitter.ajusteMensaje.domain.AjusteMensaje;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjusteMensajeOutputDto {
    private Integer idAjuste;
    private UsuarioOutputDto usuarioOutputDto;
    private boolean ajusteMensaje;
    private boolean filtroMensaje;
    private boolean confirmacionLectura;

    public AjusteMensajeOutputDto(AjusteMensaje ajusteMensaje){
        setIdAjuste(ajusteMensaje.getIdAjuste());
        setUsuarioOutputDto(new UsuarioOutputDto(ajusteMensaje.getUsuario()));
        setAjusteMensaje(ajusteMensaje.isAjusteMensaje());
        setFiltroMensaje(ajusteMensaje.isFiltroMensaje());
        setConfirmacionLectura(ajusteMensaje.isConfirmacionLectura());
    }
}
