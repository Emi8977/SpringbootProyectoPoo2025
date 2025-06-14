package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sala {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Sala; //pk

    @Column(name = "numero")
    private int numero;

    @Column(name = "capacidad")
    private int capacidad;

    @ManyToMany
    @JoinTable(
            name = "sala_funcion", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "sala_id"), // Columna en la tabla intermedia que referencia a Sala
            inverseJoinColumns = @JoinColumn(name = "funcion_id") // Columna en la tabla intermedia que referencia a Funcion
    )
    private ArrayList<Funcion> funciones = new ArrayList(); //fk

}
