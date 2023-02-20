package com.example.SpringTwitter.mensaje.controller.dtoMensaje;

import com.example.SpringTwitter.mensaje.domain.Mensaje;
import com.example.SpringTwitter.usuario.controller.dtoUsuario.UsuarioOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeOutputDto {
    private Integer idMensaje;
    private String mensaje;
    private UsuarioOutputDto usuarioEmisorOutputDto;
    private UsuarioOutputDto usuarioReceptorOutputDto;

    public MensajeOutputDto(Mensaje mensaje){
        setIdMensaje(mensaje.getIdMensaje());
        setMensaje(mensaje.getMensaje());
        setUsuarioEmisorOutputDto(new UsuarioOutputDto(mensaje.getUsuario_emisor()));
        setUsuarioReceptorOutputDto(new UsuarioOutputDto(mensaje.getUsuario_receptor()));
    }
}

