package com.airyance.manejador;

import com.airyance.comando.SolicitudEmpleado;
import com.airyance.empleado.servicio.ServicioRegistrarEmpleado;
import com.airyance.fabrica.FabricaEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarEmpleado {

    private final ServicioRegistrarEmpleado servicioRegistrarEmpleado;
    private final FabricaEmpleado fabricaEmpleado;

    public ManejadorRegistrarEmpleado(ServicioRegistrarEmpleado servicioRegistrarEmpleado, FabricaEmpleado fabricaEmpleado) {
        this.servicioRegistrarEmpleado = servicioRegistrarEmpleado;
        this.fabricaEmpleado = fabricaEmpleado;
    }

    public String ejecutar (SolicitudEmpleado solicitudEmpleado){
        return servicioRegistrarEmpleado.ejecutar(fabricaEmpleado.ejecutarRegistro(solicitudEmpleado));
    }
}
