package br.com.buscadevapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    CREATED("CREATED"),
    OPEN("OPEN"),
    ON_HOLD("ON HOLD"),
    COMPLETED("COMPLETED");

    private String description;
}
