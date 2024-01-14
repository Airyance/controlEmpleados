package com.airyance.manejador;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.servicio.ServicioConsultarEmpleado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ManejadorListarEmpleados {

    private final ServicioConsultarEmpleado servicioConsultarEmpleado;

    public ManejadorListarEmpleados(ServicioConsultarEmpleado servicioConsultarEmpleado) {
        this.servicioConsultarEmpleado = servicioConsultarEmpleado;
    }

    public Optional<List<DtoEmpleado>> ejecutar(){
        return servicioConsultarEmpleado.ejecutarListarEmpleados();
    }

}
