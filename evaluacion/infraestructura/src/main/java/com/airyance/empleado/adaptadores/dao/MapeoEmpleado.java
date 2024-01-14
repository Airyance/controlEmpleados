package com.airyance.empleado.adaptadores.dao;

import com.airyance.empleado.modelo.DtoEmpleado;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoEmpleado implements ResultSetExtractor<DtoEmpleado> {


    @Override
    public DtoEmpleado extractData(ResultSet rs) throws SQLException, DataAccessException {

        if (rs.next()) {

            LocalDate fechaIngreso = null;

            if (manejoDeFechas(rs)) {
                fechaIngreso = LocalDate.parse(rs.getString("fechaIngreso"));
            }

            return new DtoEmpleado(
                    rs.getInt("id"),
                    rs.getLong("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("fotografia"),
                    fechaIngreso,
                    rs.getInt("cargo")
            );


        } else {
            return null;
        }
    }

    private boolean manejoDeFechas(ResultSet rs) throws SQLException {

        if (rs.getDate("fechaIngreso") == null) {
            return false;
        }

        return true;
    }
}
