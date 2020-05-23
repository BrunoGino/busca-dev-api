package br.com.buscadevapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class ParamErrorDTO implements ErrorDTO {
    private String parameterName;
    private String parameterValue;
    private String message;

    @Override
    public String getCause() {
        return parameterName + " with " + parameterValue + " " + message;
    }
}
