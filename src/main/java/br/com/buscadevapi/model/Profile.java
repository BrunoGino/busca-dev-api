package br.com.buscadevapi.model;

import br.com.buscadevapi.model.composite.ProfileSkill;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany(mappedBy = "skill")
    private List<ProfileSkill> skills;
    @OneToMany(mappedBy = "profile")
    private List<Experience> experiences;
    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) &&
                Objects.equals(description, profile.description) &&
                Objects.equals(skills, profile.skills) &&
                Objects.equals(experiences, profile.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, skills, experiences);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProfileSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<ProfileSkill> skills) {
        this.skills = skills;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
