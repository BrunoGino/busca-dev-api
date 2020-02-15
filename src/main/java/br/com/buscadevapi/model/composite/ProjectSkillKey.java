package br.com.buscadevapi.model.composite;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class ProjectSkillKey {
    @Column(name = "PROJECT_ID")
    private Long projectId;
    @Column(name = "SKILL_ID")
    private Long skillId;
}
