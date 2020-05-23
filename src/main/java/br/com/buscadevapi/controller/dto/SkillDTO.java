package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Skill;
import lombok.Value;
import org.springframework.data.domain.Page;

@Value
public class SkillDTO {
    private String name;
    private String description;

    public SkillDTO(Skill skill) {
        this.description = skill.getDescription();
        this.name = skill.getName();
    }

    public static Page<SkillDTO> convertPage(Page<Skill> skills) {
        return skills.map(SkillDTO::new);
    }
}
