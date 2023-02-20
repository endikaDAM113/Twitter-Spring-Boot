package com.example.SpringTwitter.ajusteMensaje.domain;

import com.example.SpringTwitter.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AjusteMensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAjuste", nullable = false)
    private Integer idAjuste;

    @Column(name = "ajusteMensaje", nullable = false)
    private boolean ajusteMensaje;

    @Column(name = "filtroMensaje", nullable = false)
    private boolean filtroMensaje;

    @Column(name = "confirmacionLectura", nullable = false)
    private boolean confirmacionLectura;

    @OneToOne(optional = false)
    @JoinColumn(name="idUsuario", referencedColumnName = "id")
    private Usuario usuario;
}
