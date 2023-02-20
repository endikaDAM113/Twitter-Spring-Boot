package com.example.SpringTwitter.ajusteMensaje.controller.dtoAjusteMensaje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjusteMensajeInputDto {
    private Integer idUsuario;
    private boolean ajusteMensaje;
    private boolean filtroMensaje;
    private boolean confirmacionLectura;
}
