package com.airyance.empleado.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Empleado {

    private long cedula;
    private String nombre;
    private int fotografia;
    private LocalDate fechaIngreso;
    private int cargo;

    public Empleado(long cedula,String nombre, int fotografia, LocalDate fechaIngreso, int cargo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fotografia = fotografia;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }

    public Empleado(String nombre, int fotografia, LocalDate fechaIngreso, int cargo) {
        this.nombre = nombre;
        this.fotografia = fotografia;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }
}
