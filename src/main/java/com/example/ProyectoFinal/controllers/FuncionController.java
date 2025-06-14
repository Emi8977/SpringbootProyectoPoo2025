package com.example.ProyectoFinal.controllers;

import com.example.ProyectoFinal.models.Funcion;
import com.example.ProyectoFinal.services.FuncionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/funciones")
public class FuncionController {

    private final FuncionService funcionService;

    @Autowired
    public FuncionController(FuncionService funcionService) {
        this.funcionService = funcionService;
    }


    @GetMapping
    public List<Funcion> getAllFunciones() { // <-- CAMBIO AQUÍ: nombre del método y tipo de retorno
        return funcionService.getAllFunciones(); // <-- CAMBIO AQUÍ: llamar al servicio de funciones
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> getFuncionById(@PathVariable Long id) { // <-- CAMBIO AQUÍ: tipo de retorno y nombre del método
        try {
            Funcion funcion = funcionService.getFuncionById(id); // <-- CAMBIO AQUÍ: llamar al servicio de funciones
            return ResponseEntity.ok(funcion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcion createFuncion(@RequestBody Funcion funcion) { // <-- CAMBIO AQUÍ: tipo de parámetro y nombre del método
        return funcionService.createFuncion(funcion); // <-- CAMBIO AQUÍ: llamar al servicio de funciones
    }


    @PutMapping("/{id}")
    public ResponseEntity<Funcion> updateFuncion(@PathVariable Long id, @RequestBody Funcion funcionDetails) { // <-- CAMBIO AQUÍ: tipos de parámetros y nombre del método
        try {
            Funcion updatedFuncion = funcionService.updateFuncion(id, funcionDetails); // <-- CAMBIO AQUÍ: llamar al servicio de funciones
            return ResponseEntity.ok(updatedFuncion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncion(@PathVariable Long id) { // <-- CAMBIO AQUÍ: nombre del método
        try {
            funcionService.deleteFuncion(id); // <-- CAMBIO AQUÍ: llamar al servicio de funciones
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
