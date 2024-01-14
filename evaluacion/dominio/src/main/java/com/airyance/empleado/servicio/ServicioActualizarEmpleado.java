package com.airyance.empleado.servicio;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.modelo.Empleado;
import com.airyance.empleado.puerto.repositorio.RepositorioEmpleado;
import com.airyance.negocio.excepciones.ExcepcionInconsistenciaDatos;
import com.airyance.negocio.excepciones.ExcepcionSinDatos;

import java.util.Optional;

public class ServicioActualizarEmpleado {

    public static final String LOS_DATOS_DEL_EMPLEADO_A_ACTUALIZAR_SON_INCONSISTENTES = "Los datos del empleado a actualizar son inconsistentes";
    private final RepositorioEmpleado repositorioEmpleado;

    private final ServicioConsultarEmpleado servicioConsultarEmpleado;

    public ServicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado, ServicioConsultarEmpleado servicioConsultarEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
        this.servicioConsultarEmpleado = servicioConsultarEmpleado;
    }

    public Optional<DtoEmpleado> ejecutar(Empleado empleado, int id) {

        try {

            var resultado = obtenerEmpleado(empleado);

            if (resultado.isPresent() && resultado.get().getId() == id) {
                repositorioEmpleado.actualizarEmpleado(empleado, id);
            } else {
                throw new ExcepcionInconsistenciaDatos(LOS_DATOS_DEL_EMPLEADO_A_ACTUALIZAR_SON_INCONSISTENTES);
            }
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }

        return obtenerEmpleado(empleado);
    }

    private Optional<DtoEmpleado> obtenerEmpleado(Empleado empleado) {
        return servicioConsultarEmpleado.ejecutar(empleado.getCedula());
    }
}
