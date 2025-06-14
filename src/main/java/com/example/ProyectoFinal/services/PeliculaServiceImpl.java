package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Pago;
import com.example.ProyectoFinal.models.Pelicula;
import com.example.ProyectoFinal.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{
    public final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Pelicula> getAllPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula getPeliculaById(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrado"));

    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Long id, Pelicula peliculaDetails) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrado"));

        if ( peliculaDetails.getGenero() != null) {
            peliculaDetails.setGenero(peliculaDetails.getGenero());
        }
        if (peliculaDetails.getTitulo() != null) {
            pelicula.setTitulo(peliculaDetails.getTitulo());
        }

        return peliculaRepository.save(pelicula);
    }

    @Override
    public void deletePelicula(Long id) {
        if (!peliculaRepository.existsById(id)) {
            throw new RuntimeException("Pelicula no encontrado");
        }
        peliculaRepository.deleteById(id);
    }
}
