package com.airyance.empleado.puerto.dao;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.modelo.Empleado;

import java.util.List;

public interface DaoEmpleado {
    /**
     *
     * @param cedula : Documento de identificación del empleado
     * @return
     */
    DtoEmpleado buscarEmpleado(long cedula);

    /**
     *
     * @return
     */
    List<DtoEmpleado> listarEmpleados();
}
