package com.airyance.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudEmpleado {

    private long cedula;
    private String nombre;
    private int fotografia;
    private LocalDate fechaIngreso;
    private int cargo;
}
