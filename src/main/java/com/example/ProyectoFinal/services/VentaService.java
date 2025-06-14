package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;
import com.example.ProyectoFinal.models.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> getAllVenta();
    Venta getVentaById(Long id);
    Venta createVenta(Venta venta);
    Venta updateVenta(Long id, Venta ventaDetails); // Nuevo metodo para actualizar
    void deleteVenta(Long id); // Nuevo metodo para eliminar
}
