package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.Array2DHashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "entrenador")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 45, nullable = false)
    private String apellido;

    @Column(length = 255)
    private String icono;

    @Column(nullable = false)
    private float dinero;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Pokemon> pokemons = new ArrayList<>();

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Resultado> resultados = new ArrayList<>();
}
