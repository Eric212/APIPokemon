package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMercado extends JpaRepository<Mercado, Integer> {
}
