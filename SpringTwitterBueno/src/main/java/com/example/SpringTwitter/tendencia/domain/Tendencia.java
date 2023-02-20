package com.example.SpringTwitter.tendencia.domain;

import com.example.SpringTwitter.usuario.domain.Usuario;
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
public class Tendencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idTendencia;

    @Column(name = "nombreTendencia", nullable = false)
    private String nombreTendencia;

    @ManyToMany
    @JoinTable(
            name = "usuariosTendencias",
            joinColumns = @JoinColumn(name = "idTendencias", referencedColumnName
                    = "id"),
            inverseJoinColumns = @JoinColumn(name = "idUsuarios",
                    referencedColumnName = "id")
    )
    private List<Usuario> usuarioList = new ArrayList<>();
}
