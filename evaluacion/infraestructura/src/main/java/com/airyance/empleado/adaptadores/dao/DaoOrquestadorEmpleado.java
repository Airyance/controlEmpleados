package com.airyance.empleado.adaptadores.dao;

import com.airyance.empleado.modelo.DtoEmpleado;
import com.airyance.empleado.puerto.dao.DaoEmpleado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoOrquestadorEmpleado implements DaoEmpleado {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private String sqlConsultarEmpleado="";

    private String sqlListarEmpleados="";
    public DaoOrquestadorEmpleado(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DtoEmpleado buscarEmpleado(long cedula) {
        MapSqlParameterSource parametro = new MapSqlParameterSource();
        parametro.addValue("cedula",cedula);
        return this.jdbcTemplate.query(sqlConsultarEmpleado,parametro,new MapeoEmpleado());
    }

    @Override
    public List<DtoEmpleado> listarEmpleados() {
        return this.jdbcTemplate.query(sqlListarEmpleados, new MapeoListarEmpleados());
    }
}
