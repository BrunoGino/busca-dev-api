package br.com.buscadevapi.model.composite;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class ProfileSkillKey{
    @Column(name = "PROFILE_ID")
    private Long profileId;
    @Column(name = "SKILL_ID")
    private Long skillId;
}

