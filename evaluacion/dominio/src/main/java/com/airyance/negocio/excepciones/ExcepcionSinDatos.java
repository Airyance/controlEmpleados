package com.airyance.negocio.excepciones;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExcepcionSinDatos extends RuntimeException{

    public ExcepcionSinDatos(String mensage){
        super(mensage);
    }
}
