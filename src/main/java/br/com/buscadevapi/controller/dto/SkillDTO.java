package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SkillDTO {
    @JsonIgnore
    private Long id;
    private String name;
    private String description;

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.description = skill.getDescription();
        this.name = skill.getName();
    }

    public static Page<SkillDTO> convertPage(Page<Skill> skills) {
        return skills.map(SkillDTO::new);
    }

    public static List<SkillDTO> convertList(List<Skill> skills) {
        return skills.stream().map(SkillDTO::new).collect(Collectors.toList());
    }
}
