package com.airyance.negocio.excepciones;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExcepcionInconsistenciaDatos extends RuntimeException{

    public ExcepcionInconsistenciaDatos(String mensaje){
        super(mensaje);
    }
}
