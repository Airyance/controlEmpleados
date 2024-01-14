package com.airyance.fabrica;

import com.airyance.comando.SolicitudEmpleado;
import com.airyance.empleado.modelo.Empleado;
import org.springframework.stereotype.Component;

@Component
public class FabricaEmpleado {

    public Empleado ejecutarRegistro(SolicitudEmpleado solicitudEmpleado) {

        return new Empleado(solicitudEmpleado.getCedula(), solicitudEmpleado.getNombre(), solicitudEmpleado.getFotografia(),
                solicitudEmpleado.getFechaIngreso(), solicitudEmpleado.getCargo());
    }

    public Empleado ejecutarActualizacion(SolicitudEmpleado solicitudEmpleado) {

        return new Empleado(solicitudEmpleado.getNombre(), solicitudEmpleado.getFotografia(),
                solicitudEmpleado.getFechaIngreso(), solicitudEmpleado.getCargo());
    }

}
