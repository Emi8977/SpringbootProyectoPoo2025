package com.example.ProyectoFinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cliente_vip")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteVip extends Cliente{
    @Column(name = "descuento")
    private double descuento;

}
