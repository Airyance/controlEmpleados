package com.airyance;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Empleado {

    private int id;
    private int cedula;
    private int fotografia;
    private LocalDate fechaIngreso;
    private int cargo;

    public Empleado(int cedula, int fotografia, LocalDate fechaIngreso, int cargo) {
        this.cedula = cedula;
        this.fotografia = fotografia;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }

}
