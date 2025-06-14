package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;

import java.util.List;

public interface CineService {
    List<Cine> getAllCine();
    Cine getCineById(Long id);
    Cine createCine(Cine cine);
    Cine updateCine(Long id, Cine cineDetails); // Nuevo metodo para actualizar
    void deleteCine(Long id); // Nuevo metodo para eliminar

}
