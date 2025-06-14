package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Pago;
import com.example.ProyectoFinal.models.Pelicula;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> getAllPelicula();
    Pelicula getPeliculaById(Long id);
    Pelicula createPelicula(Pelicula pelicula);
    Pelicula updatePelicula(Long id, Pelicula peliculaDetails); // Nuevo metodo para actualizar
    void deletePelicula(Long id); // Nuevo metodo para eliminar

}
