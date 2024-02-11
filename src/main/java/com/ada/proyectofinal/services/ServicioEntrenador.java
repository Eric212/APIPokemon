package com.ada.proyectofinal.services;

import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.repositories.RepositoryEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEntrenador {
    @Autowired
    private RepositoryEntrenador repositoryEntrenador;

    public List<Entrenador> findAll(){
        return repositoryEntrenador.findAll();
    }
    public Entrenador findById(int id){
        return repositoryEntrenador.findById(id);
    }
    public void save(Entrenador entrenador){
        repositoryEntrenador.save(entrenador);
    }
    public void deleteById(int id){
        repositoryEntrenador.deleteById(id);
    }
    public void deleteAll(){
        repositoryEntrenador.deleteAll();
    }

}
