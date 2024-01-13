package com.airyance.configuracion;

import com.airyance.empleado.puerto.dao.DaoEmpleado;
import com.airyance.empleado.puerto.repositorio.RepositorioEmpleado;
import com.airyance.empleado.servicio.ServicioActualizarEmpleado;
import com.airyance.empleado.servicio.ServicioConsultarEmpleado;
import com.airyance.empleado.servicio.ServicioEliminarEmpleado;
import com.airyance.empleado.servicio.ServicioRegistrarEmpleado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioEmpleado {

    @Bean
    public ServicioRegistrarEmpleado servicioRegistrarEmpleado(RepositorioEmpleado repositorioEmpleado,
                                                               ServicioConsultarEmpleado servicioConsultarEmpleado) {
        return new ServicioRegistrarEmpleado(repositorioEmpleado, servicioConsultarEmpleado);
    }

    @Bean
    public ServicioEliminarEmpleado servicioEliminarEmpleado(RepositorioEmpleado repositorioEmpleado,
                                                             ServicioConsultarEmpleado servicioConsultarEmpleado) {
        return new ServicioEliminarEmpleado(repositorioEmpleado, servicioConsultarEmpleado);
    }

    @Bean
    public ServicioActualizarEmpleado servicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado,
                                                                 ServicioConsultarEmpleado servicioConsultarEmpleado) {
        return new ServicioActualizarEmpleado(repositorioEmpleado, servicioConsultarEmpleado);
    }

    @Bean
    public ServicioConsultarEmpleado servicioConsultarEmpleado(DaoEmpleado daoEmpleado) {
        return new ServicioConsultarEmpleado(daoEmpleado);
    }
}
