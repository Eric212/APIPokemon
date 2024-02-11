package com.ada.proyectofinal.services;

import com.ada.proyectofinal.Parser.Parser;
import com.ada.proyectofinal.entities.*;
import com.ada.proyectofinal.repositories.RepositoryEntrenador;
import com.ada.proyectofinal.repositories.RepositoryMercado;
import com.ada.proyectofinal.repositories.RepositoryPokemon;
import com.ada.proyectofinal.repositories.RepositoryZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataInicializer {

    @Autowired
    private RepositoryPokemon repositoryPokemon;

    @Autowired
    private RepositoryEntrenador repositoryEntrenador;

    @Autowired
    private RepositoryMercado repositoryMercado;

    @Autowired
    private RepositoryZona repositoryZona;

    @Autowired
    private Parser parser;

    public void GenerarEntrenadores(Entrenador entrenadorRecibido) {
        List<Entrenador> entrenadores = repositoryEntrenador.findAll();
        if (entrenadores.isEmpty()) {
            Entrenador entrenador = new Entrenador();
            entrenador.setNombre(entrenadorRecibido.getNombre());
            entrenador.setApellido(entrenadorRecibido.getApellido());
            entrenador.setDinero(entrenadorRecibido.getDinero());
            if(entrenadorRecibido.getIcono() == null) {
                entrenador.setIcono(null);
            }
            repositoryEntrenador.save(entrenador);
            for (Pokemon pokemon : entrenadorRecibido.getPokemons()) {
                pokemon.setEntrenador(entrenador);
                repositoryPokemon.save(pokemon);
            }
            if (!entrenadorRecibido.getResultados().isEmpty()) {
                for (Resultado resultado : entrenadorRecibido.getResultados()) {
                    resultado.setEntrenador(entrenador);
                }
            }

            Entrenador entrenador1 = new Entrenador();
            entrenador1.setNombre("Ash");
            entrenador1.setApellido("Ketchum");
            entrenador1.setDinero(150000);
            entrenador1.setIcono(null);
            repositoryEntrenador.save(entrenador1);

            Entrenador entrenador2 = new Entrenador();
            entrenador2.setNombre("Misty");
            entrenador2.setApellido("Waterflower");
            entrenador2.setDinero(150000);
            entrenador2.setIcono(null);
            repositoryEntrenador.save(entrenador2);

            Entrenador entrenador3 = new Entrenador();
            entrenador3.setNombre("Brock");
            entrenador3.setApellido("Takeshi");
            entrenador3.setDinero(150000);
            entrenador3.setIcono(null);
            repositoryEntrenador.save(entrenador3);

            Entrenador entrenador4 = new Entrenador();
            entrenador4.setNombre("Gary");
            entrenador4.setApellido("Oak");
            entrenador4.setDinero(150000);
            entrenador4.setIcono(null);
            repositoryEntrenador.save(entrenador4);
        }
    }
    public void generarZonas(){
        List<Zona> zonas = repositoryZona.findAll();
        if(zonas.isEmpty()){
            for(int i = 1; i < 5; i++){
                Zona zona = new Zona();
                zona.setNombre("Zona"+i);
                repositoryZona.save(zona);
            }
        }
    }
    public void generarPokemons() {
        List<Pokemon> pokemons = repositoryPokemon.findAll();
        if (pokemons.isEmpty()) {
            pokemons = new ArrayList<>();
            if (parser.parse()) {
                pokemons = parser.getPokemons();
            }
        }
        repositoryPokemon.saveAll(pokemons);
    }

    public void asignarPokemons() {
        List<Pokemon> pokemons = repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado();
        if (!pokemons.isEmpty()) {
            if(!repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado().isEmpty()) {
                List<Entrenador> entrenadores = repositoryEntrenador.findAll();
                int limit = 20;
                for (Entrenador entrenador : entrenadores) {
                    List<Pokemon> pokemonsParaEntrenador = repositoryPokemon.recuperarPokemons(limit);
                    asignar20Pokemons(pokemonsParaEntrenador, entrenador.getId());
                }
            }
        }
    }

    private void asignar20Pokemons(List<Pokemon> pokemons, int id_entrenador) {
        Entrenador entrenador = repositoryEntrenador.findById(id_entrenador);
        for (Pokemon pokemon : pokemons) {
            pokemon.setEntrenador(entrenador);
        }
        entrenador.setPokemons(pokemons);
        repositoryEntrenador.save(entrenador);
    }

    public void prepararMercado() {
        List<Mercado> mercados = repositoryMercado.findAll();
        if (mercados.isEmpty()) {
            Mercado mercado = new Mercado();
            mercado.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            List<Pokemon> pokemons = repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado();
            for (Pokemon pokemon : pokemons) {
                pokemon.setMercado(mercado);
            }
            mercado.setPokemons(pokemons);
            repositoryMercado.save(mercado);
        }
    }
}
