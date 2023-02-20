package com.example.SpringTwitter.mensaje.controller.dtoMensaje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeInputDto {
    private Integer idUsuarioEmisor;
    private Integer idUsuarioReceptor;
    private String mensaje;
}
