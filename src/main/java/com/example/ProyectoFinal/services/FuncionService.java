package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;
import com.example.ProyectoFinal.models.Funcion;

import java.util.List;

public interface FuncionService {

        List<Funcion> getAllFunciones();
        Funcion getFuncionById(Long id);
        Funcion createFuncion(Funcion funcion);
        Funcion updateFuncion(Long id, Funcion funcionDetails); // Nuevo metodo para actualizar
        void deleteFuncion(Long id); // Nuevo metodo para eliminar


}
