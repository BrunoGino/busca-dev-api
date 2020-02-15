package br.com.buscadevapi.model;

import lombok.Value;

import javax.persistence.*;


@Entity
@Value
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID")
    private Long id;
    private String description;
}
