package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Profile;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@Value
public class ProfileDTO {
    private String description;
    private Page<SkillDTO> skills;

    public ProfileDTO(Profile profile) {
        this.description = profile.getDescription();
        this.skills = SkillDTO.convert(new PageImpl<>(profile.getSkills()));
    }


    public static Page<ProfileDTO> convertMany(Page<Profile> profiles) {
        return profiles.map(ProfileDTO::new);
    }

    public static ProfileDTO convertOne(Profile profile) {
        return new ProfileDTO(profile);
    }

}
