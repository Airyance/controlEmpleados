package com.airyance.manejador;

import com.airyance.comando.SolicitudEmpleado;
import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.servicio.ServicioActualizarEmpleado;
import com.airyance.fabrica.FabricaEmpleado;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorActualizarEmpleado {

    private final ServicioActualizarEmpleado servicioActualizarEmpleado;
    private final FabricaEmpleado fabricaEmpleado;

    public ManejadorActualizarEmpleado(ServicioActualizarEmpleado servicioActualizarEmpleado, FabricaEmpleado fabricaEmpleado) {
        this.servicioActualizarEmpleado = servicioActualizarEmpleado;
        this.fabricaEmpleado = fabricaEmpleado;
    }

    public Optional<DtoEmpleado> ejecutar(SolicitudEmpleado solicitudEmpleado, int id){

        return servicioActualizarEmpleado.ejecutar(fabricaEmpleado.ejecutarActualizacion(solicitudEmpleado), id);
    }
}
