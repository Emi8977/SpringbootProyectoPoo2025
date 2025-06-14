package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Insumo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Insumo; //pk

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;


}
