package com.airyance.negocio.controladorExcepciones;

import com.airyance.negocio.comando.ComandoRespuesta;
import com.airyance.negocio.excepciones.ExcepcionInconsistenciaDatos;
import com.airyance.negocio.excepciones.ExcepcionRegistroExistente;
import com.airyance.negocio.excepciones.ExcepcionSinDatos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrquestadorExcepciones {

    @ExceptionHandler(value = ExcepcionSinDatos.class)
    public ResponseEntity<ComandoRespuesta> excepcionSinDatos(ExcepcionSinDatos excepcionSinDatos) {
        var comandoRespuesta = ComandoRespuesta.builder().mensaje(excepcionSinDatos.getMessage()).build();
        return new ResponseEntity(comandoRespuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ExcepcionInconsistenciaDatos.class)
    public ResponseEntity<ComandoRespuesta> excepcionInconsistencias(ExcepcionInconsistenciaDatos excepcionInconsistenciaDatos) {
        var comandoRespuesta = ComandoRespuesta.builder().mensaje(excepcionInconsistenciaDatos.getMessage()).build();
        return new ResponseEntity(comandoRespuesta, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ExcepcionRegistroExistente.class)
    public ResponseEntity<ComandoRespuesta> excepcionRegistroExistente(ExcepcionRegistroExistente excepcionRegistroExistente) {
        var comandoRespuesta = ComandoRespuesta.builder().mensaje(excepcionRegistroExistente.getMessage()).build();
        return new ResponseEntity(comandoRespuesta, HttpStatus.CONFLICT);
    }
}
