
package com.example.ProyectoFinal.controllers; // Ajusta el paquete según tu estructura

import com.example.ProyectoFinal.models.Cliente; // Asume la ubicación de tu entidad Cliente
import com.example.ProyectoFinal.services.ClienteService; // Asume la ubicación de tu interfaz ClienteService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/clientes") // Define la URL base para todos los endpoints de este controlador
public class ClienteController {

    private final ClienteService clienteService; // Inyecta la interfaz del servicio

    @Autowired // Inyección de dependencia del servicio
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllCliente();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            return ResponseEntity.ok(cliente); // Retorna 200 OK con el cliente
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Cliente no encontrado),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        // Spring Binder se encargará de mapear los parámetros del formulario HTML a las propiedades del objeto Cliente.
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(id, clienteDetails);
            return ResponseEntity.ok(updatedCliente); // Retorna 200 OK con el cliente actualizado
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Cliente no encontrado),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna un estado 204 No Content para eliminaciones exitosas
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            // Retorna un 204 No Content, indicando que la solicitud se procesó con éxito
            // y no hay contenido para enviar en la respuesta.
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            // Si el servicio lanza una RuntimeException (Cliente no encontrado),
            // retorna un 404 Not Found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
