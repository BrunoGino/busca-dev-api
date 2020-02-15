package br.com.buscadevapi.model.composite;

import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.Skill;
import lombok.Value;

import javax.persistence.*;

@Entity
@Value
public class ProfileSkill {
    @EmbeddedId
    private ProfileSkillKey id;

    @ManyToOne
    @MapsId("profile_id")
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @MapsId("skill_id")
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
