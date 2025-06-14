package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pelicula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Pelicula; //pk

    @Column(name = "titulo")
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Genero genero;

}
