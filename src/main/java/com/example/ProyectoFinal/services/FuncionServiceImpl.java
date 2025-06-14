package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Funcion;
import com.example.ProyectoFinal.models.Pago;
import com.example.ProyectoFinal.models.Pelicula;
import com.example.ProyectoFinal.repositories.EntradaRepository;
import com.example.ProyectoFinal.repositories.FuncionRepository;
import com.example.ProyectoFinal.repositories.PagoRepository;
import com.example.ProyectoFinal.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService{
    private final FuncionRepository funcionRepository;
    private final EntradaRepository entradaRepository;
    private final PeliculaRepository peliculaRepository;

    @Autowired
    public FuncionServiceImpl(FuncionRepository funcionRepository, EntradaRepository entradaRepository, PeliculaRepository peliculaRepository) {
        this.funcionRepository = funcionRepository;
        this.entradaRepository = entradaRepository;
        this.peliculaRepository = peliculaRepository;
    }


    @Override
    public List<Funcion> getAllFunciones() {
            return funcionRepository.findAll();
    }

    @Override
    public Funcion getFuncionById(Long id) {
        return funcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcion no encontrado"));

    }

    @Override
    public Funcion createFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Funcion updateFuncion(Long id, Funcion funcionDetails) {
        Funcion funcion = funcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcion no encontrada"));

        if ( funcionDetails.getEntradas() != null) {
            funcionDetails.setEntradas(funcionDetails.getEntradas());
        }
        if (funcionDetails.getHorario() != null) {
            funcion.setHorario(funcionDetails.getHorario());
        }


        if (funcionDetails.getPelicula() != null) { // Si se proporciona información de película
            if (funcionDetails.getPelicula().getId_Pelicula() != null) { // Si la película viene con un ID
                // Buscar la película en la base de datos para asociarla
                Pelicula peliculaEnDB = peliculaRepository.findById(funcionDetails.getPelicula().getId_Pelicula())
                        .orElseThrow(() -> new RuntimeException("Película con ID " + funcionDetails.getPelicula().getId_Pelicula() + " no encontrada para asociar a la función."));
                funcion.setPelicula(peliculaEnDB); // Asocia la película existente
            } else {
                throw new RuntimeException("Para asociar una película a la función, se debe proporcionar un ID de Película válido.");
            }
        } else {
            System.out.println("No se proporcionó información de película para la función " + id + ". Se mantendrá la película existente.");
        }
        return funcionRepository.save(funcion);
    }

    @Override
    public void deleteFuncion(Long id) {
        if (!funcionRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        funcionRepository.deleteById(id);
    }

}
