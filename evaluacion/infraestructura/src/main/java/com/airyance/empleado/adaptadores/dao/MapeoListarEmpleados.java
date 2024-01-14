package com.airyance.empleado.adaptadores.dao;

import com.airyance.empleado.modelo.DtoEmpleado;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MapeoListarEmpleados implements ResultSetExtractor<List<DtoEmpleado>> {
    @Override
    public List<DtoEmpleado> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<DtoEmpleado> listaEmpleados = new ArrayList<>();

        while (rs.next()) {
            var empleado = new DtoEmpleado();
            LocalDate fechaIngreso = null;

            if (manejoDeFechas(rs)) {
                fechaIngreso = LocalDate.parse(rs.getString("fechaIngreso"));
            }

            empleado.setId(rs.getInt("id"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setCedula(rs.getLong("cedula"));
            empleado.setFotografia(rs.getInt("fotografia"));
            empleado.setFechaIngreso(fechaIngreso);
            empleado.setCargo(rs.getString("descripcion_cargo"));

            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }

    private boolean manejoDeFechas(ResultSet rs) throws SQLException {

        if (rs.getDate("fechaIngreso") == null) {
            return false;
        }
        return true;
    }
}
