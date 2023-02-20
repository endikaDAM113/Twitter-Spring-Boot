package com.example.SpringTwitter.tendencia.repository;

import com.example.SpringTwitter.tendencia.domain.Tendencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TendenciaRepository extends JpaRepository<Tendencia, Integer> {
}
