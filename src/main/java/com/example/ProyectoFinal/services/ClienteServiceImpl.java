package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;
import com.example.ProyectoFinal.models.Cliente;
import com.example.ProyectoFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if ( clienteDetails.getNombre() != null) {
            clienteDetails.setNombre(clienteDetails.getNombre());
        }
        if (clienteDetails.getEmail() != null) {
            cliente.setEmail(clienteDetails.getEmail());
        }
        if (clienteDetails.getDni() != null) {
            cliente.setDni(clienteDetails.getDni());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
