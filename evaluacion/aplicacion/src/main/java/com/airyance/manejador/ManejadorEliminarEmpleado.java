package com.airyance.manejador;

import com.airyance.empleado.servicio.ServicioEliminarEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEmpleado {

    private final ServicioEliminarEmpleado servicioEliminarEmpleado;

    public ManejadorEliminarEmpleado(ServicioEliminarEmpleado servicioEliminarEmpleado) {
        this.servicioEliminarEmpleado = servicioEliminarEmpleado;
    }

    public String ejecutar(long cedula){
        return servicioEliminarEmpleado.ejecutar(cedula);
    }
}
