package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Profile;
import lombok.Value;

import java.util.List;

@Value
public class ProfileDTO {
    private String description;
    private List<SkillDTO> skills;
//    private List<ExperienceDTO> experiences;

    public ProfileDTO(Profile profile) {
        this.description = profile.getDescription();
        this.skills = SkillDTO.convert(profile.getSkills());
//        this.experiences = ExperienceDTO.convert(profile.getExperiences());
    }

    public static ProfileDTO convertOne(Profile profile) {
        return new ProfileDTO(profile);
    }

}
