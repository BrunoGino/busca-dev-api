package br.com.buscadevapi.model.composite;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.Skill;
import lombok.Value;

import javax.persistence.*;

@Entity
@Value
public class ProjectSkill {
    @EmbeddedId
    private ProjectSkillKey id;
    @ManyToOne
    @MapsId("PROJECT_ID")
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @ManyToOne
    @MapsId("SKILL_ID")
    @JoinColumn(name = "SKILL_ID")
    private Skill skill;
}
