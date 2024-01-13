package com.airyance.empleado.controladores;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.manejador.ManejadorConsultarEmpleado;
import com.airyance.manejador.ManejadorListarEmpleados;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/empleado")
public class ConsultaEmpleado {

    private ManejadorConsultarEmpleado manejadorConsultarEmpleado;
    private ManejadorListarEmpleados manejadorListarEmpleados;

    @GetMapping(value = "/{cedula}")
    public Optional<DtoEmpleado> buscarEmpleadoPorCedula(@PathVariable int cedula){
        return manejadorConsultarEmpleado.ejecutar(cedula);
    }

    @GetMapping(value = "/listar")
    public Optional<List<DtoEmpleado>> listarEmpleados (){
        return manejadorListarEmpleados.ejecutar();
    }






}
