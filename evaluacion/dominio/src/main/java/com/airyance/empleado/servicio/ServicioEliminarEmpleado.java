package com.airyance.empleado.servicio;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.puerto.repositorio.RepositorioEmpleado;
import com.airyance.negocio.excepciones.ExcepcionInconsistenciaDatos;

import java.util.Optional;

public class ServicioEliminarEmpleado {

    private static final String EL_EMPLEADO_A_ELIMINAR_NO_EXISTE = "El empleado a eliminar no existe.";
    private static final String EL_EMPLEADO_HA_SIDO_ELIMINADO_CON_EXITO = "El empleado %s ha sido eliminado con exito.";
    private final RepositorioEmpleado repositorioEmpleado;
    private final ServicioConsultarEmpleado servicioConsultarEmpleado;

    public ServicioEliminarEmpleado(RepositorioEmpleado repositorioEmpleado, ServicioConsultarEmpleado servicioConsultarEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
        this.servicioConsultarEmpleado = servicioConsultarEmpleado;
    }

    public String ejecutar(long cedula) {

        try {

            var resultado = obtenerEmpleado(cedula);

            if (resultado.isPresent()) {
                repositorioEmpleado.eliminarEmpleado(cedula, resultado.get().getId());

                return String.format(EL_EMPLEADO_HA_SIDO_ELIMINADO_CON_EXITO, resultado.get().getNombre());
            } else {
                throw new ExcepcionInconsistenciaDatos(EL_EMPLEADO_A_ELIMINAR_NO_EXISTE);
            }

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }
    }

    private Optional<DtoEmpleado> obtenerEmpleado(long cedula) {
        return servicioConsultarEmpleado.ejecutar(cedula);
    }
}
