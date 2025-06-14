package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.*;
import com.example.ProyectoFinal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
    private final VentaRepository ventaRepository;
    private final PagoRepository pagoRepository; // Agregamos el repositorio de Pago
    private final ClienteRepository clienteRepository;
    private final FuncionRepository funcionRepository;
    private  final PeliculaRepository peliculaRepository;

    @Autowired
    public VentaServiceImpl(VentaRepository ventaRepository, PagoRepository pagoRepository, ClienteRepository clienteRepository, FuncionRepository funcionRepository, PeliculaRepository peliculaRepository) {
        this.ventaRepository = ventaRepository;
        this.pagoRepository = pagoRepository;
        this.clienteRepository = clienteRepository;
        this.funcionRepository = funcionRepository;
        this.peliculaRepository = peliculaRepository;
    }

@Override
@Transactional //
public Venta createVenta(Venta ventaDetails) { // Renombrado a ventaDetails
    Venta nuevaVenta = new Venta();
    nuevaVenta.setFecha(ventaDetails.getFecha()); // Asigna la fecha directamente

    // --- Procesar Cliente ---
    //el frontend envía una lista con un solo cliente [{ id_Cliente: X }]
    if (ventaDetails.getClientes() != null && !ventaDetails.getClientes().isEmpty()) {
        Cliente clienteDelFrontend = ventaDetails.getClientes().get(0); // Tomamos el primer cliente

        // Verificar si el ID del cliente es nulo O si es una cadena vacía
        if (clienteDelFrontend.getDni() == null || clienteDelFrontend.getDni().toString().isEmpty()) {
            throw new RuntimeException("Por favor, seleccione un cliente válido para registrar la venta.");
        }

        if (clienteDelFrontend.getDni() != null) {
            // Obtener la instancia del cliente de la base de datos
            Cliente clienteEnDB = clienteRepository.findById(clienteDelFrontend.getDni())
                    .orElseThrow(() -> new RuntimeException("Cliente con ID " + clienteDelFrontend.getDni() + " no encontrado para la venta."));
            // Asociar la instancia gestionada del cliente a la nueva venta
            nuevaVenta.setClientes(List.of(clienteEnDB)); // Si es ManyToMany
        } else {
            throw new RuntimeException("El ID del cliente es necesario para registrar la venta.");
        }
    } else {
        throw new RuntimeException("Se necesita al menos un cliente para registrar la venta.");
    }

    // --- Procesar Pago ---
    if (ventaDetails.getPago() != null && ventaDetails.getPago().getId_Pago() != null) {
        Pago pagoEnDB = pagoRepository.findById(ventaDetails.getPago().getId_Pago())
                .orElseThrow(() -> new RuntimeException("Método de Pago con ID " + ventaDetails.getPago().getId_Pago() + " no encontrado."));
        nuevaVenta.setPago(pagoEnDB); // Asocia la instancia gestionada del pago
    } else {
        throw new RuntimeException("El método de pago es requerido.");
    }

    // --- Procesar Funciones ---
    if (ventaDetails.getFunciones() != null && !ventaDetails.getFunciones().isEmpty()) {
        List<Funcion> funcionesGestionadas = new ArrayList<>();
        for (Funcion funcionDetail : ventaDetails.getFunciones()) {
            if (funcionDetail.getId_Funcion() != null) {
                Funcion funcionEnDB = funcionRepository.findById(funcionDetail.getId_Funcion())
                        .orElseThrow(() -> new RuntimeException("Función con ID " + funcionDetail.getId_Funcion() + " no encontrada."));

                // si Funcion tiene Pelicula y el frontend envía el ID de Pelicula
                if (funcionDetail.getPelicula() != null && funcionDetail.getPelicula().getId_Pelicula() != null) {
                    Pelicula peliculaEnDB = peliculaRepository.findById(funcionDetail.getPelicula().getId_Pelicula())
                            .orElseThrow(() -> new RuntimeException("Película con ID " + funcionDetail.getPelicula().getId_Pelicula() + " no encontrada para la función."));
                    funcionEnDB.setPelicula(peliculaEnDB); // Asocia la Pelicula gestionada
                }
                funcionesGestionadas.add(funcionEnDB); // Agrega la función gestionada (con su Pelicula)
            } else {
                throw new RuntimeException("Una de las funciones en los detalles de la venta no tiene un ID válido.");
            }
        }
        nuevaVenta.setFunciones(funcionesGestionadas); // Asocia la lista de funciones gestionadas
    } else {
        throw new RuntimeException("La venta debe tener al menos una función.");
    }

    // se guarda la nueva venta, que ahora tiene todos sus objetos relacionados como entidades gestionadas
    return ventaRepository.save(nuevaVenta);
}

    @Override
    public List<Venta> getAllVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Venta updateVenta(Long id, Venta ventaDetails) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        if (ventaDetails.getFecha() != null) {
            venta.setFecha(ventaDetails.getFecha());
        }

        if (ventaDetails.getPago() != null && ventaDetails.getPago().getId_Pago() != null) {
            Pago pagoExistente = pagoRepository.findById(ventaDetails.getPago().getId_Pago())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
            venta.setPago(pagoExistente);
        }

        if (ventaDetails.getClientes() != null && !ventaDetails.getClientes().isEmpty()) {
            List<Cliente> clientesActualizados = new ArrayList<>();
            for (Cliente clienteDetail : ventaDetails.getClientes()) {
                if (clienteDetail.getDni() != null) {
                    // Buscar el cliente en la base de datos para asegurar que existe
                    Cliente clienteEnDB = clienteRepository.findById(clienteDetail.getDni())
                            .orElseThrow(() -> new RuntimeException("Cliente con ID " + clienteDetail.getDni() + " no encontrado para la venta."));
                    // si el cliente existe, se agrega a la lista de clientes actualizados.
                    // esto asegura que la Venta tenga una referencia a un Cliente persistido y completo.
                    clientesActualizados.add(clienteEnDB);
                } else {
                    throw new RuntimeException("Uno de los clientes en los detalles de la venta no tiene un ID válido.");
                }
            }
            // Asignar la lista de clientes verificados y cargados desde la DB a la venta existente
            venta.setClientes(clientesActualizados);
        } else {
             System.out.println("No se proporcionaron clientes en los detalles de la venta. Se mantienen los clientes existentes.");
        }

        // --- edicion para las funciones ---
        // verifica si ventaDetails contiene una lista de funciones para procesar
        if (ventaDetails.getFunciones() != null && !ventaDetails.getFunciones().isEmpty()) {
            List<Funcion> funcionesActualizadas = new ArrayList<>();
            for (Funcion funcionDetail : ventaDetails.getFunciones()) {
                if (funcionDetail.getId_Funcion() != null) { // Asumo que el ID de Funcion es 'id'
                    // buscar la función en la base de datos para asegurar que existe
                    Funcion funcionEnDB = funcionRepository.findById(funcionDetail.getId_Funcion())
                            .orElseThrow(() -> new RuntimeException("Función con ID " + funcionDetail.getId_Funcion() + " no encontrada para la venta."));
                    funcionesActualizadas.add(funcionEnDB);
                } else {
                    throw new RuntimeException("Una de las funciones en los detalles de la venta no tiene un ID válido.");
                }
            }
            // asignar la lista de funciones verificadas y cargadas desde la DB a la venta
            venta.setFunciones(funcionesActualizadas);
        } else {
            System.out.println("No se proporcionaron funciones en los detalles de la venta. Se mantienen las funciones existentes.");
        }
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        if (!ventaRepository.existsById(id)) {
            throw new RuntimeException("Venta no encontrada");
        }
        ventaRepository.deleteById(id);
    }
}
