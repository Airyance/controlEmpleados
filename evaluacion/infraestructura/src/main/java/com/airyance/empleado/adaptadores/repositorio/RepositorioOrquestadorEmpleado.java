package com.airyance.empleado.adaptadores.repositorio;

import com.airyance.empleado.modelo.Empleado;
import com.airyance.empleado.puerto.repositorio.RepositorioEmpleado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrquestadorEmpleado implements RepositorioEmpleado {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private String sqlCrearEmpleado = "";
    private String sqlActualizarEmpleado = "";
    private String sqlEliminarEmpleado = "";

    public RepositorioOrquestadorEmpleado(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crearEmpleado(Empleado empleado) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("cedula", empleado.getCedula());
        parametros.addValue("nombre", empleado.getNombre());
        parametros.addValue("fechaIngreso", empleado.getFechaIngreso());
        parametros.addValue("fotografia", empleado.getFotografia());
        parametros.addValue("cargo", empleado.getCargo());

        return (long) jdbcTemplate.update(sqlCrearEmpleado, parametros);
    }

    @Override
    public Long actualizarEmpleado(Empleado empleado, int id) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("id", id);
        parametros.addValue("cedula", empleado.getCedula());
        parametros.addValue("nombre", empleado.getNombre());
        parametros.addValue("fechaIngreso", empleado.getFechaIngreso());
        parametros.addValue("fotografia", empleado.getFotografia());
        parametros.addValue("cargo", empleado.getCargo());

        return (long) jdbcTemplate.update(sqlActualizarEmpleado, parametros);
    }

    @Override
    public Long eliminarEmpleado(long cedula, int id) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("id", id);
        parametros.addValue("cedula", cedula);

        return (long) jdbcTemplate.update(sqlEliminarEmpleado, parametros);
    }
}
