package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseService {
    private String mensajeUsuario;

    private Integer codigoRespuesta;

    private String mensajeTecnico;

    private Map<String, Object> contenido;


}
