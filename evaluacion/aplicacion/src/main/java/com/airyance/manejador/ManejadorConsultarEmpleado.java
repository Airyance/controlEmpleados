package com.airyance.manejador;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.servicio.ServicioConsultarEmpleado;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorConsultarEmpleado {

    private final ServicioConsultarEmpleado servicioConsultarEmpleado;

    public ManejadorConsultarEmpleado(ServicioConsultarEmpleado servicioConsultarEmpleado) {
        this.servicioConsultarEmpleado = servicioConsultarEmpleado;
    }

    public Optional<DtoEmpleado> ejecutar(long cedula){
        return servicioConsultarEmpleado.ejecutar(cedula);
    }
}
