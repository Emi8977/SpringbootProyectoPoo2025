package com.example.ProyectoFinal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entrada")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entrada {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Entrada; //pk

    @Column(name = "precio")
    private double precio;

    @Column(name = "asiento")
    private String asiento;

    @ManyToMany(mappedBy = "entradas")
    @JsonIgnore
    private List<Funcion> funciones= new ArrayList();//en entrada debe haber un fk de funcion

}
