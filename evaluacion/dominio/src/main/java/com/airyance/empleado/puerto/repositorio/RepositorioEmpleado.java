package com.airyance.empleado.puerto.repositorio;

import com.airyance.empleado.modelo.Empleado;

public interface RepositorioEmpleado {

    /**
     *
     * @param empleado
     * @return
     */
    Long crearEmpleado (Empleado empleado);

    /**
     *
     * @param empleado
     * @param id
     * @return
     */
    Long actualizarEmpleado (Empleado empleado, int id);

    /**
     *
     * @param id
     * @return
     */
    Long eliminarEmpleado (long cedula,int id);
}
