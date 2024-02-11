package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.Parser.Parser;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.ServicioMercado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mercado")
public class ControllerMercado {
    @Autowired
    private ServicioMercado servicioMercado;


}
