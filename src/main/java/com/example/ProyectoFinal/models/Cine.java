package com.example.ProyectoFinal.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Table(name = "cine")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Cine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Cine; //pk

    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;

    @Setter
    @Getter
    @Column(name = "direccion")
    private String direccion;


//    @OneToMany
//    @JoinColumn (name = "id_cine")
    ArrayList<Sala> salas= new ArrayList();//fk


    //fk
//    @OneToMany
//    @JoinColumn (name = "id_cine")
    ArrayList<Pelicula>peliculas= new ArrayList();

    //son fk
//    @OneToMany
//    @JoinColumn (name = "id_cine")
    ArrayList<Venta>ventas= new ArrayList();

//    @OneToMany
//    @JoinColumn (name = "id_cine")
//    ArrayList<Compra>compras=new ArrayList();
//
//    @ManyToMany(mappedBy = "cines") // El valor "cines" debe coincidir con el nombre del campo en Empleado
    ArrayList<Empleado>empleados=new ArrayList();
}
