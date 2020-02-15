package br.com.buscadevapi.model.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfileSkillKey implements Serializable {
    @Column(name = "profile_id")
    private Long profileId;
    @Column(name = "skill_id")
    private Long skillId;

    public ProfileSkillKey() {
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileSkillKey)) return false;
        ProfileSkillKey that = (ProfileSkillKey) o;
        return getProfileId().equals(that.getProfileId()) &&
                getSkillId().equals(that.getSkillId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileId(), getSkillId());
    }
}

