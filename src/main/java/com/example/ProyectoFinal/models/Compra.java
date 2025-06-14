package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "compra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Compra {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Compra; //pk

    @Column(name = "fecha")
    private String fecha;

    @OneToMany
    @JoinColumn (name = "id_compra")
    ArrayList<Insumo> insumos = new ArrayList(); //fk

    @OneToMany
    @JoinColumn (name = "id_compra")
    ArrayList<Proveedor>proveedores = new ArrayList();//fk

}
