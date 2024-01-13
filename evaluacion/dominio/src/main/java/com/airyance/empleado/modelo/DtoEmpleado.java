package com.airyance.empleado.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmpleado {

    private int id;
    private long cedula;
    private String nombre;
    private int fotografia;
    private LocalDate fechaIngreso;
    private int cargo;


}
