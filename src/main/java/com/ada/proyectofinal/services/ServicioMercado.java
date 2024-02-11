package com.ada.proyectofinal.services;

import com.ada.proyectofinal.entities.Mercado;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.repositories.RepositoryMercado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMercado {
    @Autowired
    private RepositoryMercado repositoryMercado;

    public List<Mercado> findAll(){
        return repositoryMercado.findAll();
    }

    public void findById(int id){
        repositoryMercado.findById(id);
    }

    public void saveAll(List<Mercado> mercados){
        repositoryMercado.saveAll(mercados);
    }
    public void save(Mercado mercado){
        repositoryMercado.save(mercado);
    }

    public void deleteById(int id){
        repositoryMercado.deleteById(id);
    }

    public void deleteAll(){
        repositoryMercado.deleteAll();
    }

    public void ListarPokemonsDelMercado(){
        //
    }

    public void guardarPokemonsEnMercado(List<Pokemon> pokemons) {
            Mercado mercado = new Mercado();
            mercado.setPokemons(pokemons);
            save(mercado);
    }
}
