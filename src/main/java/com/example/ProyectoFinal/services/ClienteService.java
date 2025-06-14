package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;
import com.example.ProyectoFinal.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente clienteDetails); // Nuevo metodo para actualizar
    void deleteCliente(Long id); // Nuevo metodo para eliminar

}
