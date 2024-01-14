package com.airyance.empleado.controladores;

import com.airyance.comando.SolicitudEmpleado;
import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.manejador.ManejadorActualizarEmpleado;
import com.airyance.manejador.ManejadorEliminarEmpleado;
import com.airyance.manejador.ManejadorRegistrarEmpleado;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/empleados")
public class ControladorEmpleado {

    private ManejadorRegistrarEmpleado manejadorRegistrarEmpleado;
    private ManejadorActualizarEmpleado manejadorActualizarEmpleado;
    private ManejadorEliminarEmpleado manejadorEliminarEmpleado;

    @PostMapping(value = "/crear")
    private ResponseEntity<String> crearEmpleado(@RequestBody SolicitudEmpleado solicitudEmpleado) {
        return new ResponseEntity<>(manejadorRegistrarEmpleado.ejecutar(solicitudEmpleado), null, HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    private Optional<DtoEmpleado> actualizarEmpleado(@RequestBody SolicitudEmpleado solicitudEmpleado, @PathVariable int id) {
        return manejadorActualizarEmpleado.ejecutar(solicitudEmpleado, id);
    }

    @DeleteMapping(value = "/eliminar/{cedula}")
    private ResponseEntity<String> eliminarEmpleado(@PathVariable long cedula) {
        return new ResponseEntity<>(manejadorEliminarEmpleado.ejecutar(cedula), null, HttpStatus.OK);
    }


}
