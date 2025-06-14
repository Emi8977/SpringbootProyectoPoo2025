package com.example.ProyectoFinal.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalaVip extends Sala {

    @Column(name = "beneficios")
    private String beneficios;

}
