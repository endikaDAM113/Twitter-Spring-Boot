package com.example.SpringTwitter.usuario.domain;

import com.example.SpringTwitter.ajusteMensaje.domain.AjusteMensaje;
import com.example.SpringTwitter.mensaje.domain.Mensaje;
import com.example.SpringTwitter.tendencia.domain.Tendencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idUsuario;

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario;

    @OneToOne(mappedBy = "usuario")
    private AjusteMensaje ajustesMensajes;

    @OneToMany(mappedBy = "usuario_emisor", fetch = FetchType.LAZY)
    private List<Mensaje> mensajesMandados;

    @OneToMany(mappedBy = "usuario_receptor", fetch = FetchType.LAZY)
    private List<Mensaje> mensajesRecibidos;

    @ManyToMany(mappedBy = "usuarioList")
    private List<Tendencia> tendenciasList = new ArrayList<>();
}
