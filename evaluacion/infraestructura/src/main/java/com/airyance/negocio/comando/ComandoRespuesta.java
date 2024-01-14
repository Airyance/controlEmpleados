package com.airyance.negocio.comando;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComandoRespuesta {

    private String mensaje;
}
