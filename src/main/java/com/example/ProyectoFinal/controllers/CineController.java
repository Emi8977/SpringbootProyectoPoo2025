package com.example.ProyectoFinal.controllers; // Ajusta el paquete según tu estructura

import com.example.ProyectoFinal.models.Cine; // Asume la ubicación de tu entidad Cine
import com.example.ProyectoFinal.services.CineService; // Asume la ubicación de tu interfaz CineService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/cines") // Define la URL base para todos los endpoints de este controlador
public class CineController {

    private final CineService cineService; // Inyecta la interfaz del servicio

    @Autowired // Inyección de dependencia del servicio
    public CineController(CineService cineService) {
        this.cineService = cineService;
    }


    @GetMapping
    public List<Cine> getAllCines() {
        return cineService.getAllCine();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cine> getCineById(@PathVariable Long id) {
        try {
            Cine cine = cineService.getCineById(id);
            return ResponseEntity.ok(cine); // Retorna 200 OK con el cine
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna un estado 201 Created al crear un recurso
    public Cine createCine(@RequestBody Cine cine) {
        return cineService.createCine(cine);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cine> updateCine(@PathVariable Long id, @RequestBody Cine cineDetails) {
        try {
            Cine updatedCine = cineService.updateCine(id, cineDetails);
            return ResponseEntity.ok(updatedCine); // Retorna 200 OK con el cine actualizado
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna un estado 204 No Content para eliminaciones exitosas
    public ResponseEntity<Void> deleteCine(@PathVariable Long id) {
        try {
            cineService.deleteCine(id);
            return ResponseEntity.noContent().build(); // Eliminación exitosa
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Cine no encontrado
        }
    }
}
