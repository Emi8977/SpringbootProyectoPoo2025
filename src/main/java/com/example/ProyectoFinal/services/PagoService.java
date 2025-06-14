package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Pago;

import java.util.List;

public interface PagoService {
    List<Pago> getAllPago();
    Pago getPagoById(Long id);
    Pago createPago(Pago cine);
    Pago updatePago(Long id, Pago pagoDetails); // Nuevo metodo para actualizar
    void deletePago(Long id); // Nuevo metodo para eliminar

}
