package br.com.buscadevapi.model;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Value
public class Skill {
    @Id
    private Long id;
    private String description;
}
