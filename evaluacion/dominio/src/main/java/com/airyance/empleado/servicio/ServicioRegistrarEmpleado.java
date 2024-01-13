package com.airyance.empleado.servicio;

import com.airyance.empleado.modelo.Empleado;
import com.airyance.empleado.puerto.dao.DaoEmpleado;
import com.airyance.empleado.puerto.repositorio.RepositorioEmpleado;

import java.util.Optional;

public class ServicioRegistrarEmpleado {

    private static final String NO_FUE_POSIBLE_CREAR_EL_EMPLEADO_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR = "No fue posible crear el empleado, por favor contacte al administrador.";
    private static final String YA_EXISTE_EL_EMPLEADO_A_REGISTRAR = "Ya existe el empleado a registrar";
    private static final String HA_SIDO_CREADO_EXITOSAMENTE_EL_REGISTRO_PARA = "Ha sido creado exitosamente el registro para: %1s empleado";
    private final RepositorioEmpleado repositorioEmpleado;
    private final ServicioConsultarEmpleado servicioConsultarEmpleado;

    public ServicioRegistrarEmpleado(RepositorioEmpleado repositorioEmpleado, ServicioConsultarEmpleado servicioConsultarEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
        this.servicioConsultarEmpleado= servicioConsultarEmpleado;
    }

    public String ejecutar(Empleado empleado) {

        try {

            var registrosPrevios = Optional.ofNullable(servicioConsultarEmpleado.ejecutar(empleado.getCedula()));

            if (registrosPrevios.isPresent()) {
                throw new RuntimeException(YA_EXISTE_EL_EMPLEADO_A_REGISTRAR);
            }
            return creacionEmpleado(empleado);
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }

    }

    private String creacionEmpleado(Empleado empleado) {

        var registroCreado = repositorioEmpleado.crearEmpleado(empleado);

        String resultado = NO_FUE_POSIBLE_CREAR_EL_EMPLEADO_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR;

        if (registroCreado > 0) {
            resultado = String.format(HA_SIDO_CREADO_EXITOSAMENTE_EL_REGISTRO_PARA, registroCreado);
        }
        return resultado;
    }
}
