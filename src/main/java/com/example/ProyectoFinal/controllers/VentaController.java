
package com.example.ProyectoFinal.controllers; // Ajusta el paquete según tu estructura

import com.example.ProyectoFinal.models.Venta; // Asume la ubicación de tu entidad Venta
import com.example.ProyectoFinal.repositories.ClienteRepository;
import com.example.ProyectoFinal.services.VentaService; // Asume la ubicación de tu interfaz VentaService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/ventas") // Define la URL base para todos los endpoints de este controlador
public class VentaController {

    private final VentaService ventaService; // Inyecta la interfaz del servicio
//    private final ClienteRepository clienteRepository;
//    private final FuncionRepository funcionRepository;


    @Autowired // Inyección de dependencia del servicio
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }


    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVenta();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        try {
            Venta venta = ventaService.getVentaById(id);
            return ResponseEntity.ok(venta); // Retorna 200 OK con la venta
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Venta no encontrada),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna un estado 201 Created al crear un recurso
    public Venta createVenta(@RequestBody Venta venta) {
        // @RequestBody mapea el JSON del cuerpo de la solicitud a un objeto Venta
        return ventaService.createVenta(venta);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta ventaDetails) {
        try {
            Venta updatedVenta = ventaService.updateVenta(id, ventaDetails);
            return ResponseEntity.ok(updatedVenta); // Retorna 200 OK con la venta actualizada
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Venta no encontrada),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna un estado 204 No Content para eliminaciones exitosas
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        try {
            ventaService.deleteVenta(id);
            // Retorna un 204 No Content, indicando que la solicitud se procesó con éxito
            // y no hay contenido para enviar en la respuesta.
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Venta no encontrada),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}