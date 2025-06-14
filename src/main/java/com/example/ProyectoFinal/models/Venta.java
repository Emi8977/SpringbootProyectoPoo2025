package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Venta; //pk

    @Column(name = "fecha")
    private String fecha;


    @ManyToMany
    @JoinTable(
            name = "venta_funcion", // Un nombre significativo para esta nueva tabla intermedia
            joinColumns = @JoinColumn(name = "venta_id"), // Columna en la tabla intermedia que referencia a Venta
            inverseJoinColumns = @JoinColumn(name = "funcion_id") // Columna en la tabla intermedia que referencia a Funcion (asumiendo que 'Funcion' es la entidad relacionada)
    )
    private List<Funcion> funciones = new ArrayList(); //fk

    ////arreglado
    @ManyToOne
    @JoinColumn(name = "pago_id", unique = false) // sin unique=true
    private Pago pago;


////arreglado
    @ManyToMany
    @JoinTable(
            name = "venta_cliente", // tabla intermedia
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id") // ESTA LÍNEA FALTABA
    )
    private List<Cliente> clientes = new ArrayList<>();


}
