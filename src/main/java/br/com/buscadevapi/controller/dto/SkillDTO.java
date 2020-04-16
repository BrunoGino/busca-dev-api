package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Skill;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SkillDTO {
    private String name;
    private String description;

    public SkillDTO(Skill skill) {
        this.description = skill.getDescription();
        this.name = skill.getName();
    }

    public static Page<SkillDTO> convert(Page<Skill> skills) {
        return skills.map(SkillDTO::new);
    }
}
