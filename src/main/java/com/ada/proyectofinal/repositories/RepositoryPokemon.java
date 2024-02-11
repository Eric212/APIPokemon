package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RepositoryPokemon extends JpaRepository<Pokemon, Integer>{
    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id IS NULL Limit :limit", nativeQuery = true)
    List<Pokemon> recuperarPokemons(int limit);

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id = :id",nativeQuery = true)
    List<Pokemon> getPokemonsByEntrenadorId(int id);

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id IS NULL AND mercado_id IS NULL", nativeQuery = true)
    List<Pokemon> comprobarPokemonsSinEntrenadorNiMercado();
}
