package com.example.SpringTwitter.ajusteMensaje.repository;

import com.example.SpringTwitter.ajusteMensaje.domain.AjusteMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AjusteMensajeRepository extends JpaRepository<AjusteMensaje, Integer> {
}
