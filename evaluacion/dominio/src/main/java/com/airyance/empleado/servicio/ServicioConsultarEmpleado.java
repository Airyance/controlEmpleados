package com.airyance.empleado.servicio;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.puerto.dao.DaoEmpleado;

import java.util.List;
import java.util.Optional;

public class ServicioConsultarEmpleado {

    private final DaoEmpleado daoEmpleado;

    public ServicioConsultarEmpleado(DaoEmpleado daoEmpleado) {
        this.daoEmpleado = daoEmpleado;
    }

    public Optional<DtoEmpleado> ejecutar(long cedula){
        Optional<DtoEmpleado> empleado = Optional.ofNullable(daoEmpleado.buscarEmpleado(cedula));
        return empleado;
    }

    public Optional<List<DtoEmpleado>> ejecutarListarEmpleados(){
        Optional<List<DtoEmpleado>> empleados = Optional.ofNullable(daoEmpleado.listarEmpleados());
        return empleados;
    }

}
