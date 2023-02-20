package com.example.SpringTwitter.mensaje.domain;

import com.example.SpringTwitter.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idMensaje;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name="usuario_emisor_id",referencedColumnName = "id")
    private Usuario usuario_emisor;

    @ManyToOne
    @JoinColumn(name="usuario_receptor_id",referencedColumnName = "id")
    private Usuario usuario_receptor;
}
