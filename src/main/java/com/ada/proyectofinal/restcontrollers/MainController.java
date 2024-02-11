package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.services.DataInicializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private DataInicializer dataInicializer;

    @PostMapping("/generar")
    public ResponseEntity<String> generarDatos(@RequestBody Entrenador entrenador){
        dataInicializer.GenerarEntrenadores(entrenador);
        dataInicializer.generarZonas();
        dataInicializer.generarPokemons();
        dataInicializer.asignarPokemons();
        dataInicializer.prepararMercado();
        return new ResponseEntity<>("Funciona", HttpStatus.OK);
    }
}
