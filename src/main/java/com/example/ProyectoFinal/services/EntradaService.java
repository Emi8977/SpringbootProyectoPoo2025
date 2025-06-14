package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Entrada;
import com.example.ProyectoFinal.models.Funcion;

import java.util.List;

public interface EntradaService {

    List<Entrada> getAllEntrada();
    Entrada getEntradaById(Long id);
    Entrada createEntrada(Entrada entrada);
    Entrada updateEntrada(Long id, Entrada entradaDetails); // Nuevo metodo para actualizar
    void deleteEntrada(Long id); // Nuevo metodo para eliminar

}
