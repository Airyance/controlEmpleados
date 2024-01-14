package com.airyance.negocio.excepciones;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExcepcionRegistroExistente extends RuntimeException{

    public ExcepcionRegistroExistente(String mensaje){
        super(mensaje);
    }
}
