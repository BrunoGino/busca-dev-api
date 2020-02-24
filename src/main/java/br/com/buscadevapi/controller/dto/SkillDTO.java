package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.Skill;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SkillDAO {
    private String name;
    private String description;

    public SkillDAO(Skill skill) {
        this.description = skill.getDescription();
        this.name = skill.getName();
    }

    public static List<SkillDAO> convert(List<Skill> skills) {
        return skills.stream().map(SkillDAO::new).collect(Collectors.toList());
    }
}
