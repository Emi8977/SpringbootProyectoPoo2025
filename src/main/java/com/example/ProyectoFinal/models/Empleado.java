package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Empleado; //pk

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private int dni;

    @ManyToMany(
        cascade = { CascadeType.PERSIST, CascadeType.MERGE }
        )
    @JoinTable(
        name = "empleado_cine", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "empleado_id"), // Clave foránea a Empleado
        inverseJoinColumns = @JoinColumn(name = "cine_id") // Clave foránea a Cine
    )    
    private ArrayList<Cine> cines = new ArrayList();

}
