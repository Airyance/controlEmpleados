package com.airyance.empleado.servicio;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.puerto.dao.DaoEmpleado;
import com.airyance.negocio.excepciones.ExcepcionSinDatos;

import java.util.List;
import java.util.Optional;

public class ServicioConsultarEmpleado {

    private static final String NO_SE_HA_ENCONTRADO_EL_EMPLEADO_CON_ESA_IDENTIFICACION = "No se ha encontrado el empleado con esa identificacion";
    private static final String NO_HAY_EMPLEADOS_PARA_LISTAR = "No hay empleados para listar.";
    private final DaoEmpleado daoEmpleado;

    public ServicioConsultarEmpleado(DaoEmpleado daoEmpleado) {
        this.daoEmpleado = daoEmpleado;
    }

    public Optional<DtoEmpleado> ejecutar(long cedula) {
        Optional<DtoEmpleado> empleado = Optional.ofNullable(daoEmpleado.buscarEmpleado(cedula));
        if (empleado.isEmpty()) {
            throw new ExcepcionSinDatos(NO_SE_HA_ENCONTRADO_EL_EMPLEADO_CON_ESA_IDENTIFICACION);
        }
        return empleado;
    }

    public Optional<List<DtoEmpleado>> ejecutarListarEmpleados() {
        Optional<List<DtoEmpleado>> empleados = Optional.ofNullable(daoEmpleado.listarEmpleados());
        if (empleados.isEmpty()) {
            throw new ExcepcionSinDatos(NO_HAY_EMPLEADOS_PARA_LISTAR);
        }
        return empleados;
    }

}
