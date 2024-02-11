package com.ada.proyectofinal.restcontrollers;

import ch.qos.logback.core.model.Model;
import com.ada.proyectofinal.entities.Alineacion;
import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.ServicioEntrenador;
import com.ada.proyectofinal.services.ServicioMercado;
import com.ada.proyectofinal.services.ServicioPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/entrenador")
public class ControllerEntrenador {
    @Autowired
    private ServicioEntrenador servicioEntrenador;

    @GetMapping("/{id}")
    public ResponseEntity<Optional> getPerfil(@PathVariable int id) {
        Optional<Entrenador> entrenador = Optional.ofNullable(servicioEntrenador.findById(id));
        return new ResponseEntity<>(entrenador, HttpStatus.OK);
    }

    @GetMapping("/{id}/alineacion")
    public ResponseEntity<List<Optional<Pokemon>>> getAlineacion(@PathVariable int id) {
        Entrenador entrenador = servicioEntrenador.findById(id);
        List<Pokemon> pokemons = entrenador.getPokemons();
        List<Optional<Pokemon>> alineacion = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getAlineacion() != null) {
                Optional<Pokemon> oPokemon = Optional.of(pokemon);
                alineacion.add(oPokemon);
            }
        }
        return new ResponseEntity<>(alineacion, HttpStatus.OK);
    }

    /*@GetMapping("/alinear")
    public ResponseEntity<String> setAlineacion(@PathVariable int id,Model pokemonsAlineados) {
        Entrenador entrenador = servicioEntrenador.findById(id);
        List<Pokemon> pokemons = entrenador.getPokemons();
        List<Optional<Pokemon>> alineacion = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if () {
                Optional<Pokemon> oPokemon = Optional.of(pokemon);
                alineacion.add(oPokemon);
            }
        }
        return new ResponseEntity<>("Alineado", HttpStatus.OK);
    }*/
}
