package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.Parser.Parser;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.ServicioPokemon;
import jakarta.websocket.server.PathParam;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class ControllerPokemon {
    @Autowired
    private ServicioPokemon servicioPokemon;

    @GetMapping
    public List<Pokemon> showPokemons(@PathParam("id") int id){
        return servicioPokemon.getPokemonsByEntrenadorId(id);
    }
}
