package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cine;
import com.example.ProyectoFinal.repositories.CineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CineServiceImpl implements CineService {
    private final CineRepository cineRepository;

    @Autowired
    public CineServiceImpl(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }


    @Override
    public List<Cine> getAllCine() {
        return cineRepository.findAll();
    }

    @Override
    public Cine getCineById(Long id) {
        return cineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Cine createCine(Cine cine) {
        return cineRepository.save(cine);
    }

    @Override
    public Cine updateCine(Long id, Cine cineDetails) {
        Cine cine = cineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cine no encontrado"));

        if ( cineDetails.getNombre() != null) {
            cine.setNombre(cineDetails.getNombre());
        }
        if (cineDetails.getDireccion() != null) {
            cine.setDireccion(cineDetails.getDireccion());
        }

        return cineRepository.save(cine);
    }

    @Override
    public void deleteCine(Long id) {
        if (!cineRepository.existsById(id)) {
            throw new RuntimeException("Cine no encontrado");
        }
        cineRepository.deleteById(id);
    }
}
