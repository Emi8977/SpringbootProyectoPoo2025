package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Entrada;
import com.example.ProyectoFinal.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaServiceImpl implements EntradaService{
    private final EntradaRepository entradaRepository;

    @Autowired
    public EntradaServiceImpl(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }


    @Override
    public List<Entrada> getAllEntrada() {
        return entradaRepository.findAll();
    }

    @Override
    public Entrada getEntradaById(Long id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrado"));

    }

    @Override
    public Entrada createEntrada(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @Override
    public Entrada updateEntrada(Long id, Entrada entradaDetails) {
        Entrada entrada = entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("entrada no encontrada"));

        if ( entradaDetails.getAsiento() != null) {
            entradaDetails.setAsiento(entradaDetails.getAsiento());
        }
        if (entradaDetails.getPrecio() != 00.00) {
            entrada.setPrecio(entradaDetails.getPrecio());
        }

        return entradaRepository.save(entrada);
    }

    @Override
    public void deleteEntrada(Long id) {
        if (!entradaRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        entradaRepository.deleteById(id);
    }
}
