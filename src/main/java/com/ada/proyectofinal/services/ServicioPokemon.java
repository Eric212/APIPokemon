package com.ada.proyectofinal.services;

import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.repositories.RepositoryEntrenador;
import com.ada.proyectofinal.repositories.RepositoryPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServicioPokemon {
    @Autowired
    private RepositoryPokemon repositoryPokemon;
    @Autowired
    private RepositoryEntrenador repositoryEntrenador;

    public List<Pokemon> findAll(){
        return repositoryPokemon.findAll();
    }
    public void findById(int id){
         repositoryPokemon.findById(id);
    }

    public void save(Pokemon pokemon){
        repositoryPokemon.save(pokemon);
    }

    public void deleteById(int id){
        repositoryPokemon.deleteById(id);
    }

    public void deleteAll(){
        repositoryPokemon.deleteAll();
    }

    public List<Pokemon> recuperarPokemon(int limit){
        return repositoryPokemon.recuperarPokemons(limit);
    }

    public List<Pokemon> getPokemonsByEntrenadorId(int id) {
        return repositoryPokemon.getPokemonsByEntrenadorId(id);
    }
}
