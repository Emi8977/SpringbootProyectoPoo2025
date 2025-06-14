package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Funcion; //pk

    @Column(name = "horario")
    private String horario;

    @ManyToOne
    private Pelicula pelicula; //fk

    @ManyToMany
    @JoinTable(
            name = "funcion_entrada", // Choose a meaningful name for the join table
            joinColumns = @JoinColumn(name = "funcion_id"), // Column in join table referring to Funcion
            inverseJoinColumns = @JoinColumn(name = "entrada_id") // Column in join table referring to Entrada (assuming you have an Entrada entity)
    )
    private List<Entrada> entradas= new ArrayList();//en entrada debe haber un fk de funcion

}
