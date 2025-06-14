package com.example.ProyectoFinal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_Pago; //pk

    @Column(name = "monto")
    private double monto;

    @Enumerated(EnumType.STRING)
    private TipoPago tipo;


    private ArrayList<Venta> ventas =new ArrayList();//fk

}
