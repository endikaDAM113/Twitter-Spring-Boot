package com.example.SpringTwitter.mensaje.repository;

import com.example.SpringTwitter.mensaje.domain.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
