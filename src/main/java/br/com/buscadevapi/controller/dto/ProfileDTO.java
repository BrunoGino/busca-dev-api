package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.Profile;
import lombok.Value;

import java.util.List;

@Value
public class ProfileDAO {
    private String description;
    private List<SkillDAO> skills;
    private List<ExperienceDAO> experiences;

    public ProfileDAO(Profile profile) {
        this.description = profile.getDescription();
        this.skills = SkillDAO.convert(profile.getSkills());
        this.experiences = ExperienceDAO.convert(profile.getExperiences());
    }

    public static ProfileDAO convertOne(Profile profile) {
        return new ProfileDAO(profile);
    }

}
